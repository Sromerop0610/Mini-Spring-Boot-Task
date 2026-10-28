
package edu.iesrafaelalberti.minispringboottask;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class TaskTest {

    @Test
    void newTaskIsNotCompleted() {
        Task task = new Task("Comprar leche");

        assertFalse(task.isCompleted());
    }
}
