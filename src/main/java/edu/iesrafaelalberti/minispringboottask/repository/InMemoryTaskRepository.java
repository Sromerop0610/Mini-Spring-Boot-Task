
package edu.iesrafaelalberti.minispringboottask.repository;

import edu.iesrafaelalberti.minispringboottask.SimpleTask;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryTaskRepository implements TaskRepository {

    private final List<SimpleTask> tasks = new ArrayList<>();

    @Override
    public SimpleTask save(SimpleTask task) {
        tasks.add(task);
        return task;
    }
}
