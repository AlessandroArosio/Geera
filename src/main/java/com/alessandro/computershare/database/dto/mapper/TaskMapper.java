package com.alessandro.computershare.database.dto.mapper;

import com.alessandro.computershare.database.dto.TaskDTO;
import com.alessandro.computershare.database.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {

  TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

  TaskDTO taskToDTO(Task task);
  Task dtoToTask(TaskDTO taskDTO);
}
