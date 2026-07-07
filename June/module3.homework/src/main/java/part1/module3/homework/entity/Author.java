package part1.module3.homework.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<Book> books;
}
