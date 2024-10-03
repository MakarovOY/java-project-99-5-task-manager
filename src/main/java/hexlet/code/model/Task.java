package hexlet.code.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tasks")
@EntityListeners(AuditingEntityListener.class)
public class Task implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1)
    private String name;
    private Integer index;
    private String description;
    @NotNull
    @ManyToOne
    private TaskStatus taskStatus;
    @ManyToOne
    private User assignee;
    @CreatedDate
    private LocalDate createdAt;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Label> labels;


}
