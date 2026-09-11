package br.com.company.library.repository.memory;

import br.com.company.library.domain.Loan;
import br.com.company.library.repository.LoanRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryLoanRepository implements LoanRepository {

    private final Map<Long, Loan> loans = new HashMap<>();

    public Loan save(Loan loan){
        loans.put(loan.getId(), loan);
        return loan;
    }

    public Optional<Loan> findById(Long id){
        return Optional.ofNullable(loans.get(id));
    }

    public List<Loan> findAll(){
        return List.copyOf(loans.values());
    }
}
