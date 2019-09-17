package com.alessandro.computershare;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Geera implements CommandLineRunner {
  public static void main(String[] args) {
    SpringApplication.run(Geera.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("Enter a name: ");
//
//    String name = scanner.nextLine();
//    System.out.println("you wrote: " + name);
  }
}
