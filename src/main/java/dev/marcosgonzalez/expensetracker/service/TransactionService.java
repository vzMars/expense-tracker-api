package dev.marcosgonzalez.expensetracker.service;

import dev.marcosgonzalez.expensetracker.dto.TransactionInfo;
import dev.marcosgonzalez.expensetracker.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionInfo> getTransactions(Integer id) {
        return transactionRepository.findTransactionsByUserId(id);
    }
}
