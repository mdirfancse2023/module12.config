package part1.module3.homework.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import part1.module3.homework.entity.Author;
import part1.module3.homework.service.AuthorService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/author")
public class AuthorController {
    private AuthorService authorService;

    @PostMapping("/createAuthor")
    public void addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
    }

    public void getAllAuthors(){

    }

    public void getAuthor(){

    }

    public void updateAuthor(){

    }

    public void deleteAuthor(){

    }

    public void getAllBooks(){

    }
}
