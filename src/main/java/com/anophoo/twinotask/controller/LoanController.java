package com.anophoo.twinotask.controller;

import com.anophoo.twinotask.model.LoanApplication;
import com.anophoo.twinotask.repo.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
  @Autowired private LoanRepository loanRepository;

  @GetMapping
  public Iterable findAll() {
    return loanRepository.findAll();
  }

  // TODO: change to custom exceptions
  @GetMapping("/{id}")
  public LoanApplication findOne(@PathVariable Long id) {
    return loanRepository.findById(id).orElseThrow(RuntimeException::new);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public LoanApplication create(@RequestBody LoanApplication loanApplication) {
    return loanRepository.save(loanApplication);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    loanRepository.findById(id).orElseThrow(RuntimeException::new);
    loanRepository.deleteById(id);
  }

  @PutMapping("/{id}")
  public LoanApplication updateLoanApplication(
      @RequestBody LoanApplication loanApplication, @PathVariable Long id) {
    if (!loanApplication.getId().equals(id)) {
      throw new RuntimeException();
    }
    loanRepository.findById(id).orElseThrow(RuntimeException::new);
    return loanRepository.save(loanApplication);
  }
}
