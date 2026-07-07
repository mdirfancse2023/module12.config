package june.module7.homework.service;

import june.module7.homework.dto.AuthorDto;
import june.module7.homework.entity.Author;
import june.module7.homework.entity.Book;
import june.module7.homework.repository.AuthorRepository;
import june.module7.homework.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    public String addAuthor(AuthorDto author) {
        Author author1 = Author.builder()
                .name(author.name())
                .build();
        authorRepository.save(author1);
        return "Author added successfully";
    }

    public String assignBook(String name, String title) {
        Book book = bookRepository.findByTitle(title);
        Author author = authorRepository.findByName(name);
        book.setAuthor(author);
        author.getBooks().add(book);
        bookRepository.save(book);
        return "Book assign successfully";
    }
}
