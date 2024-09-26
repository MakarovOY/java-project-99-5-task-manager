package hexlet.code.mapper;



import hexlet.code.dto.TaskStatusCreatedDTO;
import hexlet.code.dto.TaskStatusDTO;
import hexlet.code.dto.TaskStatusUpdatedDTO;
import hexlet.code.model.TaskStatus;
import org.mapstruct.*;

@Mapper(
        uses = { JsonNullableMapper.class },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class TaskStatusMapper {
    public abstract TaskStatus map(TaskStatusCreatedDTO dto);
    public abstract TaskStatusDTO map(TaskStatus model);
    public abstract void update(TaskStatusUpdatedDTO dto, @MappingTarget TaskStatus model);
}
