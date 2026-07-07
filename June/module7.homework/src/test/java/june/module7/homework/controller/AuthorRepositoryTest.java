package june.module7.homework.controller;

import june.module7.homework.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthorController.class)
class AuthorRepositoryTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AuthorService authorService;

    @Test
    void testAddAuthor() throws Exception {

        when(authorService.addAuthor(any()))
                .thenReturn("Author added successfully");

        mockMvc.perform(post("/api/v1/author/addAuthor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "name":"Irfan"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(content().string("Author added successfully"));
    }

    @Test
    void testAssignBook() throws Exception {

        when(authorService.assignBook("Irfan", "Spring Boot"))
                .thenReturn("Book assigned successfully");

        mockMvc.perform(patch("/api/v1/author/assignBook")
                        .param("name", "Irfan")
                        .param("title", "Spring Boot"))
                .andExpect(status().isOk())
                .andExpect(content().string("Book assigned successfully"));
    }
}