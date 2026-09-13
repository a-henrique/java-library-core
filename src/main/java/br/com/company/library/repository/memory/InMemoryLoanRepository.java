package br.com.company.library.repository.memory;

import br.com.company.library.domain.Loan;
import br.com.company.library.repository.LoanRepository;

import java.util.*;

public class InMemoryLoanRepository implements LoanRepository {

    private final Map<UUID, Loan> loans = new HashMap<>();

    public Loan save(Loan loan){
        loans.put(loan.getId(), loan);
        return loan;
    }

    public Optional<Loan> findById(UUID id){
        return Optional.ofNullable(loans.get(id));
    }

    public List<Loan> findAll(){
        return List.copyOf(loans.values());
    }

    public List<Loan> findByUserId(Long userId){
        return loans.values()
                .stream()
                .filter(loan -> loan.getUser().getId().equals(userId))
                .toList();

    }

}
