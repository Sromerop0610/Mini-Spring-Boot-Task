
package edu.iesrafaelalberti.minispringboottask;

import edu.iesrafaelalberti.minispringboottask.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskControllerV1 {

    private final List<SimpleTask> tasks = new ArrayList<>();
    private long nextId = 1;

    private final TaskService service;

    public TaskControllerV1(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<SimpleTask> list() {
        return tasks;
    }

    @PostMapping
    public SimpleTask create(@RequestBody CreateTaskDTO dto) {
        SimpleTask task = service.createTask(dto);
        tasks.add(task);
        return task;
    }

    @GetMapping("/{id}")
    public SimpleTask getById(@PathVariable Long id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
