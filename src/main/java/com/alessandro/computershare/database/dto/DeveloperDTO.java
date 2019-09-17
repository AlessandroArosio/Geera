package com.alessandro.computershare.database.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeveloperDTO {
  private Integer id;
  private String name;
  private String email;
  private List<TaskDTO> taskList;
}
