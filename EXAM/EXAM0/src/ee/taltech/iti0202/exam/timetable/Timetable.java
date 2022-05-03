package ee.taltech.iti0202.exam.timetable;

import java.util.*;
import java.util.stream.Collectors;

public class Timetable {
    public HashMap<Integer, Integer> dayCapacity = new HashMap<>();
    public HashMap<Integer, ArrayList<Task>> dayMap = new HashMap<>();
    public ArrayList<Task> taskHolder = new ArrayList<>();
    private static int helper = 0;

    public Timetable() {

    }

    public boolean checkName(int day, String name) {
        ArrayList<Task> listToCheck = dayMap.get(day);
        for (Task task : listToCheck) {
            if (task.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public Optional<String> addTask(String name, int day, int duration, boolean priority) {
        if (dayMap.containsKey(day)) {
            ArrayList<Task> toIterate = dayMap.get(day);
            for (Task task : toIterate) {
                if (task.getName().equals(name)) {
                    return Optional.empty();
                }
            }
            if (duration + dayCapacity.get(day) > 5 || duration > 5 || duration < 1) {
                return Optional.empty();
            }
            Task newTask = new Task(name, day, duration, priority);
            helper += 1;
            String taskCode = "T" + helper;
            newTask.setTaskCode(taskCode);
            dayMap.get(day).add(newTask);
            int toPut = dayCapacity.get(day) + duration;
            dayCapacity.replace(day, toPut);
            taskHolder.add(newTask);
            return Optional.of(taskCode);
        }
        if (day >= 1 && duration >= 1 && duration <= 5) {
            Task newTask = new Task(name, day, duration, priority);
            helper += 1;
            String taskCode = "T" + helper;
            newTask.setTaskCode(taskCode);
            ArrayList<Task> tasks = new ArrayList<>();
            tasks.add(newTask);
            dayMap.put(day, tasks);
            dayCapacity.put(day, duration);
            taskHolder.add(newTask);
            return Optional.of(taskCode);
        }
        return Optional.empty();
    }

    public boolean markTaskDone(String taskNumber) {
        for (Task task : taskHolder) {
            if (task.getTaskCode().equals(taskNumber)) {
                if (!task.isDone()) {
                    task.markAsDone();
                    int newCapacity = dayCapacity.get(task.getDay()) - task.getDuration();
                    dayCapacity.replace(task.getDay(), newCapacity);
                    dayMap.get(task.getDay()).remove(task);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Task> sort(ArrayList<Task> listToSort) {
        ArrayList<Task> finalList = new ArrayList<>();
        List<Task> iterLit = new ArrayList<>(listToSort);
        for (Task task : iterLit) {
            if (task.isPriority()) {
                finalList.add(task);
                listToSort.remove(task);
            }
        }
        finalList.addAll(listToSort);
        return finalList;
    }

    public List<String> getTasksForDay(int day) {
        ArrayList<String> tasks = new ArrayList<>();
        if (day >= 1) {
            ArrayList<Task> toSort = dayMap.get(day);
            ArrayList<Task> taskToIterate = sort(toSort);
            for (Task task : taskToIterate) {
                String taskName = task.getTaskCode() + " " + task.getName();
                tasks.add(taskName);
            }
        }
        return tasks;
    }

    public static void main(String[] args) {

        Timetable timetable = new Timetable();
        String task1 = timetable.addTask("wake up1", 1, 1, false).get();
        String task2 = timetable.addTask("wake up2", 1, 1, false).get();
        String task3 = timetable.addTask("wake up3", 1, 1, false).get();
        String task4 = timetable.addTask("wake up4", 1, 1, false).get();
        String task5 = timetable.addTask("wake up5", 1, 1, false).get();
        Optional<String> task6 = timetable.addTask("wake up6", 1, 1, false);
        System.out.println(task6); // Optional.empty(), day already full

        timetable.addTask("swim", 4, 3, true).get();
// cannot have the same task name on the same day (swim), whatever the other parameters are
        System.out.println(timetable.addTask("swim", 4, 1, false)); // Optional.empty
        System.out.println(timetable.getTasksForDay(1));
// [T1 wake up1, T2 wake up2, T3 wake up3, T4 wake up4, T5 wake up5]
        System.out.println(timetable.markTaskDone(task3)); // true
        System.out.println(timetable.markTaskDone(task3)); // false, cannot mark task done twice
        System.out.println(timetable.getTasksForDay(1));
// [T1 wake up1, T2 wake up2, T4 wake up4, T5 wake up5]
// now we can add additional task for day one, priority one!
        String task7 = timetable.addTask("sleep", 1, 1, true).get();
// priority task comes first
        System.out.println(timetable.getTasksForDay(1));
// [T7 sleep, T1 wake up1, T2 wake up2, T4 wake up4, T5 wake up5]

        timetable.addTask("eat", 2, 2, false);
        timetable.addTask("walk", 2, 2, true);
// priority task comes first
        System.out.println(timetable.getTasksForDay(2));
// [T9 walk, T8 eat]

// timetables are independent
        Timetable tt = new Timetable();
// we should not get an error here:
        tt.addTask("wake up1", 1, 1, false).get();

    }
}
