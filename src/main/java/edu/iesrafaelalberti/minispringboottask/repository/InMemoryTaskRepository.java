
package edu.iesrafaelalberti.minispringboottask.repository;

import edu.iesrafaelalberti.minispringboottask.SimpleTask;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryTaskRepository implements TaskRepository {

    private final List<SimpleTask> tasks = new ArrayList<>();
    private long nextId = 1;

    @Override
    public SimpleTask save(SimpleTask task) {
        if (task.getId() == null) {
            task.setId(nextId++);
        }

        tasks.add(task);
        return task;
    }

    @Override
    public List<SimpleTask> findAll() {
        return tasks;
    }

    @Override
    public Optional<SimpleTask> findById(Long id) {
        return tasks.stream()
                .filter(task -> task.getId() != null && task.getId().equals(id))
                .findFirst();
    }
}
