package part1.module3.homework.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "admission_record")
@Getter
@Setter
public class AdmissionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer fees;

    @OneToOne
    @JoinColumn(name = "student_id")
    Student student;
}
