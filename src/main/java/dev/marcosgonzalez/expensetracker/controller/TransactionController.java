package dev.marcosgonzalez.expensetracker.controller;

import dev.marcosgonzalez.expensetracker.dto.CreateTransactionBody;
import dev.marcosgonzalez.expensetracker.dto.TransactionInfo;
import dev.marcosgonzalez.expensetracker.model.User;
import dev.marcosgonzalez.expensetracker.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<TransactionInfo> getTransactions(Authentication authentication) {
        return transactionService.getTransactions(authentication);
    }

    @PostMapping
    public TransactionInfo createTransaction(@RequestBody @Valid CreateTransactionBody body, Authentication authentication) {
        return transactionService.createTransaction(body, authentication);
    }
}
