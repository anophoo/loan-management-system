package com.anophoo.twinotask.repo;

import com.anophoo.twinotask.model.LoanApplication;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "loans", path = "loans")
public interface LoanRepository extends CrudRepository<LoanApplication, Long> {


  List<LoanApplication> findByLastName(@Param("last￿Name")String lastName);

  List<LoanApplication> findByFirstName(@Param("firstName")String firstName);

  List<LoanApplication> findByEmployer(@Param("employer")String employer);

  LoanApplication findById(long id);
}
