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
                if (tasksMap.get(oneDay).size() == 5 && duration > 5) {
                    return Optional.empty();
                }
                if (tasksMap.get(oneDay).size() + duration > 5) {
                    return Optional.empty();
                }
                if (nameMap.get(day).contains(name)) {
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
}
