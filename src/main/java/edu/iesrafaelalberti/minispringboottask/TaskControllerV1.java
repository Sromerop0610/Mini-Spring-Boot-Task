
package edu.iesrafaelalberti.minispringboottask;

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

    @GetMapping
    public List<SimpleTask> list() {
        return tasks;
    }

    @PostMapping
    public SimpleTask create(@RequestBody CreateTaskDTO dto) {
        SimpleTask task = new SimpleTask(nextId++, dto.title(), false);
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
