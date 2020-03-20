package com.anophoo.twinotask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.anophoo.twinotask.repo")
@EntityScan("com.anophoo.twinotask.model")
@SpringBootApplication
public class TwinoTaskApplication {

  public static void main(String[] args) {
    SpringApplication.run(TwinoTaskApplication.class, args);
  }
}
