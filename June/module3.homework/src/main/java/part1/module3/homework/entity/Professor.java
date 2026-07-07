package part1.module3.homework.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "professor")
@Getter
@Setter
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String name;

    @ManyToMany(mappedBy = "professors")
    @JsonIgnoreProperties("professors")
    List<Student> students;

    @OneToOne(mappedBy = "professor")
    List<Subject> subjects;
}
