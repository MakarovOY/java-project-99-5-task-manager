package hexlet.code.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    @Email
    @NotNull
    @Column(unique = true)
    private String email;
    private String password;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
