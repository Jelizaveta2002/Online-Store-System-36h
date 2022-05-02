package ee.taltech.iti0202.exam.timetable;

import java.util.*;

public class Timetable {
    public HashMap<String, Integer> tasks = new HashMap<>();
    public HashMap<Integer, Integer> days = new HashMap<>();
    public HashMap<Integer, ArrayList<String>> tasksMap = new HashMap<>();
    public HashMap<Integer, ArrayList<String>> nameMap = new HashMap<>();
    private static int helper = 0;

    public Timetable() {

    }
    public Optional<String> addTask(String name, int day, int duration, boolean priority) {
        helper += 1;
        String taskCode = "T" + helper;
        for (Integer oneDay : tasksMap.keySet()) {
            if (oneDay.equals(day)) {
                if (tasksMap.get(oneDay).size() == 5 || duration > 5) {
                    return Optional.empty();
                }
                if ((tasksMap.get(oneDay).size() + duration) > 5) {
                    return Optional.empty();
                }
                if (nameMap.get(oneDay).contains(name)) {
                    return Optional.empty();
                }
                else {
                    tasksMap.get(oneDay).add(taskCode);
                    nameMap.get(oneDay).add(name);
                    return Optional.of(taskCode);
                }
            }
        }
        if (duration <= 5 && duration >= 1 && day >= 1) {
            ArrayList<String> list = new ArrayList<>();
            ArrayList<String> names = new ArrayList<>();
            list.add(taskCode);
            names.add(name);
            tasksMap.put(day, list);
            nameMap.put(day, names);
            return Optional.of(taskCode);
        }
        return Optional.empty();
    }

    public boolean markTaskDone(String taskNumber) {
        return false;
    }

    public List<String> getTasksForDay(int day) {
        return null;
    }

//    public static void main(String[] args) {
//        Timetable timetable = new Timetable();
//
//        String task1 = timetable.addTask("wake up1", 1, 1, false).get();
//        String task2 = timetable.addTask("wake up2", 1, 1, false).get();
//        String task3 = timetable.addTask("wake up3", 1, 1, false).get();
//        String task4 = timetable.addTask("wake up4", 1, 1, false).get();
//        String task5 = timetable.addTask("wake up4", 1, 1, false).get();
//        //Optional<String> task6 = timetable.addTask("wake up6", 1, 1, false);
//        //System.out.println(task6); // Optional.empty(), day already full
//        System.out.println(timetable.nameMap);
//    }
}
