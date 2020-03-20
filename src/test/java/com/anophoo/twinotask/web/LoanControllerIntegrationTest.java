package com.anophoo.twinotask.web;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.anophoo.twinotask.repo.LoanRepository;
import org.apache.http.entity.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(LoanController.class)
@AutoConfigureMockMvc
public class LoanControllerIntegrationTest {

  @Autowired LoanController loanController;

  @MockBean private LoanRepository loanRepository;

  @Autowired private MockMvc mockMvc;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(loanController).build();
  }

  @Test
  public void whenUserControllerInjected_thenNotNull() throws Exception {
    // given

    // when

    // then
    assertThat(loanController).isNotNull();
  }

  @Test
  public void whenGetRequestToUsers_thenCorrectResponse() throws Exception {
    // given

    // when & then
    mockMvc
        .perform(MockMvcRequestBuilders.get("/api/loans").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  public void whenPostRequestToLoansAndInvalidLoan_thenCorrectResponse() throws Exception {
    // given
    String loan =
        "{\"personalId\": \"13\", \"firstName\": , \"lastName\": \"The Great\", "
            + "\"birthDate\": \"1990-05-01T00:00:00\", \"employer\": \"Twino\", \"salary\": \"100\", "
            + "\"liability\": \"1000\", \"requestedAmount\": \"20030\", \"requestedTerm\": \"3\"}";

    // when & then
    mockMvc
        .perform(
            post("/api/loans")
                .content(loan)
                .contentType(String.valueOf(ContentType.APPLICATION_JSON)))
        .andExpect(status().isBadRequest());
  }
}
