
package edu.iesrafaelalberti.minispringboottask.repository;

import edu.iesrafaelalberti.minispringboottask.SimpleTask;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    SimpleTask save(SimpleTask task);

    List<SimpleTask> findAll();

    Optional<SimpleTask> findById(Long id);
}
