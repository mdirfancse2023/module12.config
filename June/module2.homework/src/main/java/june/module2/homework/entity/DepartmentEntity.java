package june.module2.homework.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "department")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    String title;

    @NotNull
    boolean isActive;

    @PastOrPresent
    LocalDateTime createdAt;
}
