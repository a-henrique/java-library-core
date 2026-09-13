package br.com.company.library.repository;

import br.com.company.library.domain.Loan;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoanRepository {
    Loan save(Loan loan);

    Optional<Loan> findById(UUID id);

    List<Loan> findAll();

    List<Loan> findByUserId(Long userId);

}
