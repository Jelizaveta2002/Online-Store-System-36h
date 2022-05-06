package ee.taltech.iti0202.exam.timetable;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TimetableTest {

    @Test
    void checkName() {
        Timetable timetable = new Timetable();
        timetable.addTask("test1", 3, 1, false);
        assertTrue(timetable.markTaskDone("T1"));
    }

    @Test
    void addTask() {
        Timetable timetable = new Timetable();
        Optional<String> taskNumber = timetable.addTask("Test", 1, 1, false);
        assertEquals(taskNumber.get(), "T1");
    }

    @Test
    void markTaskDone() {
        Timetable timetable = new Timetable();
        timetable.addTask("test1", 3, 1, false);
        timetable.addTask("test2", 3, 1, false);
        assertEquals(timetable.getTasksForDay(3), Arrays.asList("T1 test1", "T2 test2"));
    }

    @Test
    void sort() {
        Timetable timetable = new Timetable();
        timetable.addTask("test1", 3, 1, false);
        assertTrue(timetable.markTaskDone("T1"));
    }

    @Test
    void getTasksForDay2() {
        Timetable timetable = new Timetable();
        Optional<String> taskNumber = timetable.addTask("Test", 1, 1, false);
        assertEquals(taskNumber.get(), "T1");
    }

    @Test
    void getTasksForDay3() {
        Timetable timetable = new Timetable();
        Optional<String> taskNumber = timetable.addTask("Test", 1123345, 1, false);
        assertEquals(taskNumber.get(), "T1");
    }

    @Test
    void getTasksForDay4() {
        Timetable timetable = new Timetable();
        timetable.addTask("test1", 5, 1, false);
        assertEquals(timetable.getTasksForDay(5), Arrays.asList("T1 test1"));
        timetable.markTaskDone("T1");
        assertEquals(timetable.getTasksForDay(5), Arrays.asList());
    }
}