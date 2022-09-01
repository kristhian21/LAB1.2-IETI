package eci.edu.co.tasks.controller;

import eci.edu.co.tasks.dto.TaskDto;
import eci.edu.co.tasks.entities.Task;
import eci.edu.co.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAll() {
        List<TaskDto> result = new ArrayList<>();
        for (Task task: taskService.getAll()) {
            result.add(task.toDto());
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<TaskDto> findById( @PathVariable String id ) {
        return ResponseEntity.ok(taskService.findById(id).toDto());
    }

    @PostMapping
    public ResponseEntity<TaskDto> create( @RequestBody TaskDto taskDto ) {
        return ResponseEntity.ok(taskService.create(taskDto.toEntity()).toDto());
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<TaskDto> update( @RequestBody TaskDto task, @PathVariable String id ) {
        return ResponseEntity.ok(taskService.update(task.toEntity(), id).toDto());
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete(@PathVariable String id ) {
        taskService.deleteById(id);
        return ResponseEntity.ok(true);
    }
}
