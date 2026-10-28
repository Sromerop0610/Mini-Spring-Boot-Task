
package edu.iesrafaelalberti.minispringboottask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class TaskControllerV1Test {

    @Autowired
    private MockMvc mvc;

    @Test
    void listsTasks() throws Exception {
        mvc.perform(get("/v1/tasks"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void createsTask() throws Exception {
        mvc.perform(post("/v1/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "title": "Repasar Spring Boot"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Repasar Spring Boot"))
                .andExpect(jsonPath("$.done").value(false));
    }

    @Test
    void getsTaskById() throws Exception {
        mvc.perform(post("/v1/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "title": "Repasar Spring Boot"
                            }
                            """))
                .andExpect(status().isOk());

        mvc.perform(get("/v1/tasks/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Repasar Spring Boot"))
                .andExpect(jsonPath("$.done").value(false));
    }

    @Test
    void returns404WhenTaskDoesNotExist() throws Exception {
        mvc.perform(get("/v1/tasks/999"))
                .andExpect(status().isNotFound());
    }

}
