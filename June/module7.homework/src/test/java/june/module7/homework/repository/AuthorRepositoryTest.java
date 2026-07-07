package june.module7.homework.repository;

import june.module7.homework.entity.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void testFindByName() {

        Author author = Author.builder()
                .name("Asif")
                .books(new ArrayList<>())
                .build();

        authorRepository.save(author);

        Author foundAuthor =
                authorRepository.findByName("Asif");

        assertNotNull(foundAuthor);

        assertEquals(
                "Asif",
                foundAuthor.getName()
        );
    }
}