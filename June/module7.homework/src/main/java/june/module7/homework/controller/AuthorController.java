package june.module7.homework.controller;

import june.module7.homework.dto.AuthorDto;
import june.module7.homework.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody AuthorDto author){
        return authorService.addAuthor(author);
    }

    @PatchMapping("/assignBook")
    public String assignBook(@RequestParam String name, @RequestParam String title){
        return authorService.assignBook(name,title);
    }
}
