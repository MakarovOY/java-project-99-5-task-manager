package hexlet.code.service;


import hexlet.code.dto.TaskCreatedDTO;
import hexlet.code.dto.TaskDTO;
import hexlet.code.dto.TaskUpdatedDTO;
import hexlet.code.mapper.TaskMapper;
import hexlet.code.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;


    public List<TaskDTO> getAll() {
        var tasks = taskRepository.findAll();
        return tasks.stream().map(taskMapper::map)
                .toList();
    }

    public TaskDTO show(Long id) {
        var task =  taskRepository.findById(id)
                .orElseThrow();
        return taskMapper.map(task);
    }

    public TaskDTO create(TaskCreatedDTO data) {
        var task = taskMapper.map(data);
        taskRepository.save(task);
        return taskMapper.map(task);
    }

    public TaskDTO updated(TaskUpdatedDTO data, Long id) {
        var task =  taskRepository.findById(id)
                .orElseThrow();
        taskMapper.updated(data, task);
        taskRepository.save(task);
        return taskMapper.map(task);
    }

    public void destroy(Long id) {
        taskRepository.deleteById(id);
    }
}
