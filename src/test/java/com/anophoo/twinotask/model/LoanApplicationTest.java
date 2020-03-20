package com.anophoo.twinotask.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Test;

public class LoanApplicationTest {

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
    assertThat(loanApplication.getLoanStatus()).isEqualTo(LoanStatus.PENDING);
  }
}
