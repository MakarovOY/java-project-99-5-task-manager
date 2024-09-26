package hexlet.code.controller;


import hexlet.code.dto.TaskStatusCreatedDTO;
import hexlet.code.dto.TaskStatusDTO;
import hexlet.code.dto.TaskStatusUpdatedDTO;
import hexlet.code.service.TaskStatusService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/task_statuses")
public class TaskStatusController {
    private final TaskStatusService service;

    @GetMapping("/{id}")
    public TaskStatusDTO getById(@PathVariable Long id) {
        return service.show(id);
    }

    @GetMapping()
    public ResponseEntity<List<TaskStatusDTO>> getAll() {
        var statuses = service.getAll();
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(statuses.size()))
                .body(statuses);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TaskStatusDTO create(@Valid @RequestBody TaskStatusCreatedDTO data) {
        return service.create(data);
    }

    @PutMapping("/{id}")
    public TaskStatusDTO update(@Valid @RequestBody TaskStatusUpdatedDTO data, @PathVariable Long id) {
        return service.update(data, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.destroy(id);
    }

}
