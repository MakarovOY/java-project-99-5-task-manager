package hexlet.code.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LabelCreateDTO {
    @Size(min = 3, max = 1000)
    private String name;
}
