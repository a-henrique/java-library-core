package br.com.audrin.library.repository.memory;

import br.com.audrin.library.domain.Loan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryLoanRepository {

    private final Map<Long, Loan> loans = new HashMap<>();

    public Loan save(Loan loan){
        loans.put(loan.getId(), loan);
        return loan;
    }

    public Loan findById(Long id){
        return loans.get(id);
    }

    public List<Loan> findAll(){
        return List.copyOf(loans.values());
    }
}
