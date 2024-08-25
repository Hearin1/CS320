import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("1234567890", "TaskName", "Task description goes here.");
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("1234567890"));
    }

    @Test
    public void testAddTaskWithDuplicateId() {
        Task task1 = new Task("1234567890", "TaskName1", "Task description goes here.");
        Task task2 = new Task("1234567890", "TaskName2", "Another description goes here.");
        taskService.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(task2);
        });
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("1234567890", "TaskName", "Task description goes here.");
        taskService.addTask(task);
        taskService.deleteTask("1234567890");
        assertNull(taskService.getTask("1234567890"));
    }

    @Test
    public void testDeleteTaskWithInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("nonexistent");
        });
    }

    @Test
    public void testUpdateTask() {
        Task task = new Task("1234567890", "TaskName", "Task description goes here.");
        taskService.addTask(task);
        taskService.updateTask("1234567890", "NewTaskName", "New description goes here.");

        Task updatedTask = taskService.getTask("1234567890");
        assertEquals("NewTaskName", updatedTask.getName());
        assertEquals("New description goes here.", updatedTask.getDescription());
    }

    @Test
    public void testUpdateTaskWithInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTask("nonexistent", "NewTaskName", "New description goes here.");
        });
    }
}