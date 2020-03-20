package com.anophoo.twinotask.repo;

import static org.assertj.core.api.Assertions.assertThat;

import com.anophoo.twinotask.model.LoanApplication;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LoanRepositoryIntegrationTest {
  @Autowired private TestEntityManager entityManager;

  @Autowired private LoanRepository loanRepository;

  @Test
  public void whenFindByPersonalId_thenReturnLoanApplication() {
    // given
    LoanApplication loanApplication =
        new LoanApplication(
            "1234",
            "TestMan",
            "TestSurname",
            LocalDateTime.of(1000, Month.APRIL, 26, 0, 0, 0),
            "Twino",
            1000,
            1500,
            20000,
            12);
    entityManager.persist(loanApplication);
    entityManager.flush();

    // when
    LoanApplication found = loanRepository.findByPersonalId(loanApplication.getPersonalId());

    // then
    assertThat(found.getPersonalId()).isEqualTo(loanApplication.getPersonalId());
  }

  @Test
  public void whenNotFoundByPersonalId_thenReturnNull() {
    // given
    entityManager.flush();

    // when
    LoanApplication found = loanRepository.findByPersonalId("12345");

    // then
    assertThat(found).isNull();
  }

  @Test
  public void whenFindBySameFirstName_thenReturnAll() {
    // given
    LoanApplication loanApplication =
        new LoanApplication(
            "1234",
            "TestMan",
            "TestSurname",
            LocalDateTime.of(1000, Month.APRIL, 26, 0, 0, 0),
            "Twino",
            1000,
            1500,
            20000,
            12);
    entityManager.persist(loanApplication);
    LoanApplication loanApplication2 =
        new LoanApplication(
            "123453",
            "TestMan",
            "ASBD",
            LocalDateTime.of(1000, Month.APRIL, 26, 0, 0, 0),
            "Twino",
            1000,
            1500,
            20000,
            12);
    entityManager.persist(loanApplication2);
    entityManager.flush();

    // when
    var found = loanRepository.findByFirstName("TestMan");

    // then
    assertThat(found).hasSize(2);
  }
}
