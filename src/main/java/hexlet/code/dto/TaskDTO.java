package hexlet.code.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class TaskDTO {
    private Long id;
    private Integer index;
    private LocalDate createdAt;
    @JsonProperty("assignee_id")
    private Long assigneeId;
    private String title;
    private String content;
    @JsonProperty("status")
    private String slug;
    private List<Long> taskLabelIds;
}
