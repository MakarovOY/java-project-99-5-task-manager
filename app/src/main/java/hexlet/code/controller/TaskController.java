package hexlet.code.controller;


import hexlet.code.dto.TaskCreatedDTO;
import hexlet.code.dto.TaskDTO;
import hexlet.code.dto.TaskUpdatedDTO;
import hexlet.code.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping()
    public ResponseEntity<List<TaskDTO>> getAll() {
        var tasks = taskService.getAll();
        return  ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(tasks.size()))
                .body(tasks);
    }

    @GetMapping(path = "/{id}")
    public TaskDTO getById(@PathVariable Long id) {
        return taskService.show(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO create(@Valid @RequestBody TaskCreatedDTO data) {
        return taskService.create(data);
    }

    @PutMapping(path = "/{id}")
    public TaskDTO update(@Valid @RequestBody TaskUpdatedDTO data, @PathVariable Long id) {
        return taskService.updated(data, id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        taskService.destroy(id);
    }
}
