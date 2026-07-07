package june.module7.homework.service;

import june.module7.homework.dto.BookDto;
import june.module7.homework.entity.Book;
import june.module7.homework.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void testAddBook() {

        BookDto dto = new BookDto(
                "Spring Boot",
                500L
        );

        String result = bookService.addBook(dto);

        ArgumentCaptor<Book> captor =
                ArgumentCaptor.forClass(Book.class);

        verify(bookRepository, times(1))
                .save(captor.capture());

        Book savedBook = captor.getValue();

        assertEquals("Spring Boot",
                savedBook.getTitle());

        assertEquals(500L,
                savedBook.getPrice());

        assertEquals("Book Added Successfully",
                result);
    }
}