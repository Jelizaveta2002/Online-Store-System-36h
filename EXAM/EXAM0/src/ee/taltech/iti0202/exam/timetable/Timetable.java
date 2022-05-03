package ee.taltech.iti0202.exam.timetable;

import java.util.*;

public class Timetable {
    public HashMap<Integer, Integer> capacityMap = new HashMap<>();
    public HashMap<Integer, ArrayList<String>> nameMap = new HashMap<>();
    public HashMap<String, Boolean> taskDone = new HashMap<>();
    private static int helper = 0;

    public Timetable() {

    }
    public Optional<String> addTask(String name, int day, int duration, boolean priority) {
        helper += 1;
        String taskCode = "T" + helper;
        for (Integer oneDay : capacityMap.keySet()) {
            if (oneDay.equals(day)) {
                if (capacityMap.get(oneDay) + duration > 5 || duration < 1) {
                    return Optional.empty();
                }
                if (nameMap.get(oneDay).contains(name)) {
                    return Optional.empty();
                }
                else {
                    int  toPlus = capacityMap.get(oneDay);
                    capacityMap.replace(oneDay, toPlus + duration);
                    nameMap.get(oneDay).add(name);
                    taskDone.put(taskCode, false);
                    return Optional.of(taskCode);
                }
            }
        }
        if (duration <= 5 && duration >= 1 && day >= 1) {
            ArrayList<String> names = new ArrayList<>();
            names.add(name);
            capacityMap.put(day, duration);
            nameMap.put(day, names);
            taskDone.put(taskCode, false);
            return Optional.of(taskCode);
        }
        return Optional.empty();
    }

    public boolean markTaskDone(String taskNumber) {
        if (taskDone.containsKey(taskNumber)) {
            if (taskDone.get(taskNumber).equals(false)) {
                taskDone.replace(taskNumber, true);
                return true;
            }
            return false;
        }
        return false;
    }

    public List<String> getTasksForDay(int day) {
        return null;
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
        System.out.println(timetable.markTaskDone(task3)); // true
        System.out.println(timetable.markTaskDone(task3)); // false, cannot mark task done twice
    }
}
