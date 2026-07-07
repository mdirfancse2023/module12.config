package part1.module3.homework.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import part1.module3.homework.entity.Author;
import part1.module3.homework.repository.AuthorRepo;

@AllArgsConstructor
@Service
public class AuthorService {
    private AuthorRepo authorRepo;
    public void addAuthor(Author author) {
        authorRepo.save(author);
    }
}
