package com.alessandro.computershare.database.entity;

import com.alessandro.computershare.database.entity.support.TaskType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @Column(nullable = false)
  private Integer priority;

  @Column
  private String description;

  @Column
  @Enumerated(EnumType.STRING)
  private TaskType taskType;

  @ManyToOne(fetch = FetchType.LAZY)
  private Developer developer;
}
