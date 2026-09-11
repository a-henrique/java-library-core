package br.com.company.library.repository;

import br.com.company.library.domain.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanRepository {
    Loan save(Loan loan);

    Optional<Loan> findById(Long id);

    List<Loan> findAll();

}
