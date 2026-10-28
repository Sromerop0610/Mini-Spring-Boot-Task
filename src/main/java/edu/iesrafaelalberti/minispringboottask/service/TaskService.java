
package edu.iesrafaelalberti.minispringboottask.service;

import edu.iesrafaelalberti.minispringboottask.CreateTaskDTO;
import edu.iesrafaelalberti.minispringboottask.SimpleTask;
import edu.iesrafaelalberti.minispringboottask.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository repository;
    private long nextId = 1;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public SimpleTask createTask(CreateTaskDTO dto) {
        SimpleTask task = new SimpleTask(
                nextId++,
                dto.title().strip(),
                false
        );

        return repository.save(task);
    }
}
