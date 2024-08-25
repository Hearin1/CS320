import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("1234567890", "TaskName", "Task description goes here.");
        assertEquals("1234567890", task.getTaskId());
        assertEquals("TaskName", task.getName());
        assertEquals("Task description goes here.", task.getDescription());
    }

    @Test
    public void testInvalidTaskCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "TaskName", "Task description goes here.");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123456789012", "TaskName", "Task description goes here.");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", null, "Task description goes here.");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "TaskName", "This description is way too long and should not be accepted by the task object.");
        });
    }

    @Test
    public void testSetters() {
        Task task = new Task("1234567890", "TaskName", "Task description goes here.");
        task.setName("NewTaskName");
        task.setDescription("New description goes here.");
        
        assertEquals("NewTaskName", task.getName());
        assertEquals("New description goes here.", task.getDescription());
    }
}