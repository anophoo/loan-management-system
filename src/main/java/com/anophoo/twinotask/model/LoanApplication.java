package com.anophoo.twinotask.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity // this JPA annotation denotes the whole class for storage in a relational table
public class LoanApplication {

  @Id @GeneratedValue private Long id; // generated id

  @NotBlank(message = "Personal ID is mandatory")
  private String personalId;

  @NotEmpty(message = "First name is mandatory")
  private String firstName;

  @NotEmpty(message = "Last name is mandatory")
  private String lastName;

  @NotNull(message = "Birth date is mandatory")
  private LocalDateTime birthDate;

  @NotNull(message = "Employer is mandatory")
  private String employer;

  @NotNull(message = "Salary is mandatory")
  private double salary;

  @NotNull(message = "Monthly liability is mandatory")
  private double liability;

  @NotNull(message = "Requested amount is mandatory")
  private double requestedAmount;

  @NotNull(message = "Requested term is mandatory")
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
