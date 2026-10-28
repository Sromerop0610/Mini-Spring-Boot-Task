
package edu.iesrafaelalberti.minispringboottask.service;

import edu.iesrafaelalberti.minispringboottask.CreateTaskDTO;
import edu.iesrafaelalberti.minispringboottask.SimpleTask;
import edu.iesrafaelalberti.minispringboottask.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService service;

    @Test
    void createStripsTitleEdges() {
        when(repository.save(any(SimpleTask.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        SimpleTask result = service.createTask(
                new CreateTaskDTO("  Repasar Spring Boot  ")
        );

        assertEquals("Repasar Spring Boot", result.getTitle());
        assertFalse(result.isDone());
    }

    @Test
    void createPreservesSpacesBetweenWords() {
        when(repository.save(any(SimpleTask.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        SimpleTask result = service.createTask(
                new CreateTaskDTO("Repasar  Spring   Boot")
        );

        assertEquals("Repasar  Spring   Boot", result.getTitle());
        assertFalse(result.isDone());
    }
}
