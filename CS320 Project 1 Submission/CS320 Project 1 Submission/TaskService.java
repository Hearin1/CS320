import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private Map<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        tasks.put(task.getTaskId(), task);
    }

    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        tasks.remove(taskId);
    }

    public void updateTask(String taskId, String name, String description) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found");
        }
        if (name != null && name.length() <= 20) {
            task.setName(name);
        }
        if (description != null && description.length() <= 50) {
            task.setDescription(description);
        }
    }

    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}
