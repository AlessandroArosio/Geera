package com.alessandro.computershare.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "developer")
public class Developer {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  // if we delete a developer, we don't want to delete the tasks as well
  @OneToMany(
      fetch = FetchType.EAGER,
      cascade = {
          CascadeType.DETACH,
          CascadeType.MERGE,
          CascadeType.REFRESH,
          CascadeType.PERSIST})
  @JoinColumn(name = "task_id")
  private List<Task> taskList = new ArrayList<>();

  public void addTask(Task task) {
    this.taskList.add(task);
    task.setDeveloper(this);
  }

  public void deleteTask(Task task) {
    task.setDeveloper(null);
    this.taskList.remove(task);
  }
}
