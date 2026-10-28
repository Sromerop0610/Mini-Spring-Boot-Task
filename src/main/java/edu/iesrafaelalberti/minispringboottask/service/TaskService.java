
package edu.iesrafaelalberti.minispringboottask.service;

import edu.iesrafaelalberti.minispringboottask.CreateTaskDTO;
import edu.iesrafaelalberti.minispringboottask.SimpleTask;
import edu.iesrafaelalberti.minispringboottask.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public SimpleTask createTask(CreateTaskDTO dto) {
        SimpleTask task = new SimpleTask(null, dto.title().strip(), false);
        return repository.save(task);
    }
}
