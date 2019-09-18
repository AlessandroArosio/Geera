package com.alessandro.computershare.database.dto;

import com.alessandro.computershare.database.entity.support.TaskType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO {
  private Integer id;
  private Integer priority;
  private String description;
  private TaskType taskType;
  private DeveloperDTO developer;
}
