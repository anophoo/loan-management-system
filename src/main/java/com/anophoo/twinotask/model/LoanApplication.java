package com.anophoo.twinotask.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity // this JPA annotation denotes the whole class for storage in a relational table
public class LoanApplication {

  @Id @GeneratedValue private Long id; // generated id

  private String personalId;
  private String firstName;
  private String lastName;
  private LocalDateTime birthDate;
  private String employer;
  private double salary;
  private double liability;
  private double requestedAmount;
  private int requestedTerm; // months
  private LoanStatus loanStatus;

  public LoanApplication() {}

  public LoanApplication(
      String personalId,
      String firstName,
      String lastName,
      LocalDateTime birthDate,
      String employer,
      double salary,
      double liability,
      double requestedAmount,
      int requestedTerm) {
    this.personalId = personalId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.employer = employer;
    this.salary = salary;
    this.liability = liability;
    this.requestedAmount = requestedAmount;
    this.requestedTerm = requestedTerm;
    this.loanStatus = LoanStatus.PENDING; // set status to pending at creation
  }
}
