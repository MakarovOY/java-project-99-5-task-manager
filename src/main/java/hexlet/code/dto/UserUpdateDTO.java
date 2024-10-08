package hexlet.code.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openapitools.jackson.nullable.JsonNullable;
@Data
@NoArgsConstructor
public class UserUpdateDTO {
    @Email
    private JsonNullable<String> email;
    @Size(min = 3)
    private JsonNullable<String> password;
    private JsonNullable<String> firstName;
    private JsonNullable<String> lastName;
}
