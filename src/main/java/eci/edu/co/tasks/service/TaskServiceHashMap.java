package eci.edu.co.tasks.service;

import eci.edu.co.tasks.entities.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskServiceHashMap implements TaskService{

    private final HashMap<String, Task> taskHashMap = new HashMap<>();

    @Override
    public Task create(Task task) {
        taskHashMap.put(task.getId(), task);
        return task;
    }

    @Override
    public Task findById(String id) {
        Task task = taskHashMap.get(id);
        return task;
    }

    @Override
    public List<Task> getAll() {
        List<Task> taskList = new ArrayList<>();
        for (String task: taskHashMap.keySet()) {
            taskList.add(taskHashMap.get(task));
        }
        return taskList;
    }

    @Override
    public boolean deleteById(String id) {
        taskHashMap.remove(id);
        return true;
    }

    @Override
    public Task update(Task task, String id) {
        taskHashMap.replace(id, task);
        return task;
    }
}
