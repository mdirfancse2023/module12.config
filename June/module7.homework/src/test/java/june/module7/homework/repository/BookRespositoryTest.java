package june.module7.homework.repository;

import june.module7.homework.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testFindByTitle() {

        Book book = Book.builder()
                .title("Spring Boot")
                .price(500L)
                .publishedDate(Instant.now())
                .build();

        bookRepository.save(book);

        Book foundBook =
                bookRepository.findByTitle("Spring Boot");

        assertNotNull(foundBook);

        assertEquals(
                "Spring Boot",
                foundBook.getTitle()
        );

        assertEquals(
                500L,
                foundBook.getPrice()
        );
    }
}