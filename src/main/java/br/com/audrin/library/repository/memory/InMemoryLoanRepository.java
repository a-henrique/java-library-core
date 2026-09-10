package br.com.audrin.library.repository.memory;

import br.com.audrin.library.domain.Loan;

import java.util.HashMap;
import java.util.Map;

public class InMemoryLoanRepository {

    private final Map<Long, Loan> loans = new HashMap<>();

    @Override
    public Loan save(Loan loan){
        loans.put(loan.get);
        return null;
    }
}
