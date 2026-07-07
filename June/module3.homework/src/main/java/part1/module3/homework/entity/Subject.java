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
@Table(name = "subject")
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String title;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    Professor professor;

    @ManyToMany
    @JoinTable(
            name = "subject_student",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    @JsonIgnoreProperties("subjects")
    List<Student> students;
}
