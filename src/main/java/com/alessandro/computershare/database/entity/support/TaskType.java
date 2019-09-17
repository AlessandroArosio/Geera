package com.alessandro.computershare.database.entity.support;

public enum TaskType {
  BUG("Damn bug!"),
  FEATURE("Awesome feature");

  private String description;

  TaskType(String description) { this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
