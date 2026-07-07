package june.module2.homework.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Null
    String temp;

    @NotNull
    String name;

    @AssertTrue
    Boolean isActive;

    @Min(18)
    @Max(50)
    int age;

    @DecimalMin("1000.99")
    @DecimalMax("9999.99")
    BigDecimal salary;

    @Negative
    int loss;

    @Positive
    int profit;

    @Size(min = 3, max = 10)
    String username;

    @Digits(integer = 5, fraction = 2)
    BigDecimal amount;

    @Past
    LocalDate dob;

    @Future
    LocalDate joiningDate;

    @Pattern(regexp = "^[A-Za-z]+$")
    String onlyText;

    @Email
    String email;

    @NotEmpty
    List<String> skills;

    @NotBlank
    String address;

    @Length(min = 5, max = 20)
    String password;

    @Range(min = 1, max = 100)
    int score;

    @CreditCardNumber
    String card;

    @URL
    String website;
}
