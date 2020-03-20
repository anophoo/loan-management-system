package com.anophoo.twinotask;

import com.anophoo.twinotask.model.LoanApplication;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.MediaType;

// verifies calls to the API using RestAssured
public class SpringBootBootstrapLiveTest {

  private static final String API_ROOT = "http://localhost:8081/api/loans";

  private LoanApplication createRandomLoanApplication() {
    LoanApplication loanApplication = new LoanApplication();
    loanApplication.setPersonalId(RandomStringUtils.randomAlphabetic(5));
    loanApplication.setFirstName(RandomStringUtils.randomAlphabetic(5));
    loanApplication.setLastName(RandomStringUtils.randomAlphabetic(10));
    return loanApplication;
  }

  private String createLoanAsUri(LoanApplication loanApplication) {
    var response =
        RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(loanApplication)
            .post(API_ROOT);
    return API_ROOT + "/" + response.jsonPath().get("id");
  }
}
