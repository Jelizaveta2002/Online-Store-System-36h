package ee.taltech.iti0202.exam.timetable;

public class Task {

    private String name;
    private int day;
    private int duration;
    private boolean priority;
    private String taskCode;
    private boolean isDone = false;

    public Task(String name, int day, int duration, boolean priority) {
        this.name = name;
        this.day = day;
        this.duration = duration;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getDay() {
        return day;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isPriority() {
        return priority;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public void markAsDone() {
        isDone = true;
    }
}
