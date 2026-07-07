package part1.module3.homework.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    Instant publishedDate;

    @ManyToOne
    @JoinColumn(name = "author_id")
    Author author;
}
