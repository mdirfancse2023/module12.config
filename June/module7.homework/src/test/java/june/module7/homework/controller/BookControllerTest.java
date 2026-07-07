package june.module7.homework.controller;

import june.module7.homework.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BookService bookService;

    @Test
    void testAddBook() throws Exception {

        when(bookService.addBook(any()))
                .thenReturn("Book Added Successfully");

        mockMvc.perform(post("/api/v1/books/addBook")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "title":"Spring Boot",
                                    "price":500
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(content().string("Book Added Successfully"));
    }
}