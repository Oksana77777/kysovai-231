package ru.netology.javacore;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodosTests {

    @BeforeAll
    public static void initSet() {
        System.out.println("Tests for methods of class \"Todos\"");
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Starting new test");
    }
    @AfterEach
    public void finalTest() {
        System.out.println("Test complete!");
    }

    @AfterAll
    public static void completeSet() {
        System.out.println("All tests complete! ");
    }


    @Test
    @DisplayName("Test \"addTask()\" method")
    public void addTaskTest(TestInfo addTaskTestInfo) {

        Todos todo = new Todos();
        todo.addTask("TASK");
        boolean actual = todo.getTasks().contains("TASK");

        Assertions.assertTrue(actual, addTaskTestInfo.getDisplayName() + " Not done!");
        System.out.println(addTaskTestInfo.getDisplayName() + " done!");
    }

    @Test
    @DisplayName("Test \"removeTask()\" method")
    public void removeTaskTest(TestInfo removeTaskTestInfo) {

        Todos todo = new Todos();
        todo.addTask("TASK");
        todo.removeTask("TASK");
        boolean actual = todo.getTasks().contains("TASK");

        Assertions.assertFalse(actual, removeTaskTestInfo.getDisplayName() + " Not done!");
        System.out.println(removeTaskTestInfo.getDisplayName() + " done!");
    }


    @Test
    @DisplayName("Test \"getAllTask()\" method")
    public void getAllTasksTest(TestInfo getAllTasksTestInfo) {

        Todos todo = new Todos();
        String expected = "First task" +
                " " +
                "Second task" +
                " " +
                "Third task" +
                " ";
        todo.addTask("First task");
        todo.addTask("Second task");
        todo.addTask("Third task");

        Assertions.assertEquals(expected, todo.getTasks(), getAllTasksTestInfo.getDisplayName() + " Not done!");
        System.out.println(getAllTasksTestInfo.getDisplayName() + " done!");
    }

    @Test
    @DisplayName("Test \"getAllTasksAsList()\" method")
    public void getAllTasksAsListTest(TestInfo getAllTasksAsListTestInfo) {

        Todos todo = new Todos();
        todo.addTask("First task");
        todo.addTask("Second task");
        todo.addTask("Third task");
        List<String> expected = new ArrayList<>(Arrays.asList("First task", "Second task", "Third task"));
        List<String> actual = todo.getAllTasksAsList();

        Assertions.assertEquals(expected, actual, getAllTasksAsListTestInfo.getDisplayName() + " Not done!");
        System.out.println(getAllTasksAsListTestInfo.getDisplayName() + " done!");
    }
}
