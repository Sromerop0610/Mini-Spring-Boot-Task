
package edu.iesrafaelalberti.minispringboottask;

import edu.iesrafaelalberti.minispringboottask.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/v2/tasks")
public class TaskControllerV2 {

    private final TaskService service;

    public TaskControllerV2(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SimpleTask> create(@RequestBody CreateTaskDTO dto) {
        SimpleTask task = service.createTask(dto);

        URI location = URI.create("/v2/tasks/" + task.getId());

        return ResponseEntity.created(location).body(task);
    }
}
