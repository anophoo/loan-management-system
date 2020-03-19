package com.anophoo.twinotask;

import java.time.LocalDateTime;
import java.time.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

  private final LoanRepository repository;

  @Autowired
  public DatabaseLoader(LoanRepository repository) {
    this.repository = repository;
  }

  @Override
  public void run(String... args) throws Exception {
    this.repository.save(
        new LoanApplication(
            "mxeci_ana",
            "Ana",
            "Boring",
            LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0),
            "Twino",
            100,
            1500,
            20000,
            12));
    this.repository.save(
        new LoanApplication(
            "tavzexelagebuli2",
            "Emzari",
            "Qwazy",
            LocalDateTime.of(1990, Month.MAY, 1, 0, 0, 0),
            "Twino",
            1000,
            2800,
            4000,
            13));
    this.repository.save(
        new LoanApplication(
            "qindzistavi",
            "Nana",
            "Welcome",
            LocalDateTime.of(1910, Month.DECEMBER, 8, 0, 0, 0),
            "Twino",
            200,
            3900,
            2400,
            24));
  }
}
