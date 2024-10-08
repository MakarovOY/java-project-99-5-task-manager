package hexlet.code.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@NoArgsConstructor
public class TaskStatusUpdateDTO {
    @Column(unique = true)
    @Size(min = 1)
    private JsonNullable<String> name;
    @Column(unique = true)
    @Size(min = 1)
    private JsonNullable<String> slug;
}
