package june.module7.homework.service;

import june.module7.homework.dto.AuthorDto;
import june.module7.homework.entity.Author;
import june.module7.homework.entity.Book;
import june.module7.homework.repository.AuthorRepository;
import june.module7.homework.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private AuthorService authorService;

    @Test
    void testAddAuthor() {

        AuthorDto dto = new AuthorDto("Irfan");

        String result = authorService.addAuthor(dto);

        ArgumentCaptor<Author> captor =
                ArgumentCaptor.forClass(Author.class);

        verify(authorRepository, times(1))
                .save(captor.capture());

        Author savedAuthor = captor.getValue();

        assertEquals("Irfan",
                savedAuthor.getName());

        assertEquals("Author added successfully",
                result);
    }

    @Test
    void testAssignBook() {

        Author author = Author.builder()
                .name("Irfan")
                .books(new ArrayList<>())
                .build();

        Book book = Book.builder()
                .title("Spring Boot")
                .build();

        when(bookRepository.findByTitle("Spring Boot"))
                .thenReturn(book);

        when(authorRepository.findByName("Irfan"))
                .thenReturn(author);

        String result =
                authorService.assignBook(
                        "Irfan",
                        "Spring Boot"
                );

        verify(bookRepository, times(1))
                .save(book);

        assertEquals(author,
                book.getAuthor());

        assertEquals(1,
                author.getBooks().size());

        assertEquals("Book assign successfully",
                result);
    }
}