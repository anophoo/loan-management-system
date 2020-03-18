package com.anophoo.twinotask;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "loans", path = "loans")
public interface LoanRepository extends CrudRepository<LoanApplication, Long> {


  List<LoanApplication> findByLastName(@Param("last-name")String lastName);

  List<LoanApplication> findByFirstName(@Param("first-name")String firstName);

  List<LoanApplication> findByEmployer(@Param("employer")String employer);

  LoanApplication findById(long id);
}
