package june.module7.homework.service;

import june.module7.homework.dto.BookDto;
import june.module7.homework.entity.Book;
import june.module7.homework.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public String addBook(BookDto book) {
        Book book1 = Book.builder()
                .title(book.title())
                .price(book.price())
                .publishedDate(Instant.now())
                .build();
        bookRepository.save(book1);
        return "Book Added Successfully";
    }
}
