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
        Task newTask = new Task(name, day, duration, priority);
        helper += 1;
        String taskCode = "T" + helper;
        newTask.setTaskCode(taskCode);
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
            dayMap.get(day).add(newTask);
            int toPut = dayCapacity.get(day) + duration;
            dayCapacity.replace(day, toPut);
            taskHolder.add(newTask);
            return Optional.of(taskCode);
        }
        if (day >= 1 && duration >= 1 && duration <= 5) {
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
        for (Task task : listToSort) {
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

}
