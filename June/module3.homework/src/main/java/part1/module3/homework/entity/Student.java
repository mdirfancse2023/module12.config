package part1.module3.homework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "student")
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Size(min = 5, max = 10)
    String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_professor",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    @JsonIgnoreProperties("students")
    List<Professor> professors;

    @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"students","professor"})
    List<Subject> subjects;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    AdmissionRecord admissionRecord;
}
