package com.alessandro.computershare;

import com.alessandro.computershare.i18n.I18NSupport;
import com.alessandro.computershare.ui.CommandView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Geera implements CommandLineRunner {

  @Autowired
  CommandView application;

  @Autowired
  I18NSupport i18NSupport;

  public static void main(String[] args) {
    SpringApplication.run(Geera.class, args);
  }

  @Override
  public void run(String... args) {
    System.out.println(i18NSupport.getMessage("test-message"));
    application.run();

  }
}
