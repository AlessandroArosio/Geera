package com.alessandro.computershare.database.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DeveloperDTO {
  private Integer id;
  private String name;
  private String email;
  private List<TaskDTO> taskList = new ArrayList<>();

  public void addTask(TaskDTO task) {
    this.taskList.add(task);

  }

  public void deleteTask(TaskDTO task) {
    this.taskList.remove(task);
  }
}
