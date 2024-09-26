package hexlet.code.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;




@Getter
@Setter
public class TaskCreatedDTO {

    private JsonNullable<Integer> index;

    @NotNull
    @Size(min = 1)
    private String title;

    private JsonNullable<String> content;
    @JsonProperty("status")
    @NotNull
    private String slug;
    @JsonProperty("assignee_id")
    private JsonNullable<Long> assigneeId;

}
