
package edu.iesrafaelalberti.minispringboottask;

import edu.iesrafaelalberti.minispringboottask.repository.TaskRepository;
import edu.iesrafaelalberti.minispringboottask.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskControllerV1 {

    private final TaskRepository repository;
    private final TaskService service;

    public TaskControllerV1(
            TaskRepository repository,
            TaskService service
    ) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public List<SimpleTask> list() {
        return repository.findAll();
    }

    @PostMapping
    public SimpleTask create(@RequestBody CreateTaskDTO dto) {
        return service.createTask(dto);
    }

    @GetMapping("/{id}")
    public SimpleTask getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND
                ));
    }
}
