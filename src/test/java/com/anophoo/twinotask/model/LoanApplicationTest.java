package com.anophoo.twinotask.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoanApplicationTest {

  private static Validator validator;

  @BeforeClass
  public static void setupValidatorInstance() {
    validator = Validation.buildDefaultValidatorFactory().getValidator();
  }

  @Test
  public void whenCreate_thenReturnLoanApplicationWithDefaultStatus() {
    // given
    LoanApplication loanApplication =
        new LoanApplication(
            "0012",
            "Balu",
            "MyDog",
            LocalDateTime.of(2018, Month.AUGUST, 11, 0, 0, 0),
            "Twino",
            10000,
            2500,
            2000,
            2);

    // then
    assertThat(loanApplication.getPersonalId()).isNotNull();
    assertThat(loanApplication.getLoanStatus()).isEqualTo(LoanStatus.PENDING);
  }

  @Test
  public void whenNotEmptyParameters_thenNoConstraintViolations() {
    // given
    LoanApplication loanApplication =
        new LoanApplication(
            "0012",
            "Balu",
            "MyDog",
            LocalDateTime.of(2018, Month.AUGUST, 11, 0, 0, 0),
            "Twino",
            10000,
            2500,
            2000,
            2);

    // when
    Set<ConstraintViolation<LoanApplication>> violations = validator.validate(loanApplication);

    // then
    assertThat(violations).isEmpty();
  }

  @Test
  public void whenEmptyFirstName_thenOneConstraintViolation() {
    // given
    LoanApplication loanApplication =
        new LoanApplication(
            "0012",
            "",
            "MyDog",
            LocalDateTime.of(2018, Month.AUGUST, 11, 0, 0, 0),
            "Twino",
            10000,
            2500,
            2000,
            2);

    // when
    Set<ConstraintViolation<LoanApplication>> violations = validator.validate(loanApplication);

    // then
    assertThat(violations).hasSize(1);
  }

  @Test
  public void whenNullFirstName_thenOneConstraintViolation() {
    // given
    LoanApplication loanApplication =
        new LoanApplication(
            "0012",
            null,
            "MyDog",
            LocalDateTime.of(2018, Month.AUGUST, 11, 0, 0, 0),
            "Twino",
            10000,
            2500,
            2000,
            2);

    // when
    Set<ConstraintViolation<LoanApplication>> violations = validator.validate(loanApplication);

    // then
    assertThat(violations.size()).isEqualTo(1);
  }
}
