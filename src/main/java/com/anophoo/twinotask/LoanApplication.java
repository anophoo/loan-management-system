package com.anophoo.twinotask;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity // this JPA annotation denotes the whole class for storage in a relational table
@Data
public class LoanApplication {

  @Id @GeneratedValue private Long id;

  private String firstName;
  private String lastName;
  private Date birthDate;
  private String employer;
  private double salary;
  private double liability;
  private double requestedAmount;
  private int requestedTerm; // months

  public LoanApplication() {}

  public LoanApplication(
      String firstName,
      String lastName,
      Date birthDate,
      String employer,
      double salary,
      double liability,
      double requestedAmount,
      int requestedTerm) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.employer = employer;
    this.salary = salary;
    this.liability = liability;
    this.requestedAmount = requestedAmount;
    this.requestedTerm = requestedTerm;
  }
}
