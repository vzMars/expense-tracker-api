package dev.marcosgonzalez.expensetracker.controller;

import dev.marcosgonzalez.expensetracker.dto.TransactionInfo;
import dev.marcosgonzalez.expensetracker.model.User;
import dev.marcosgonzalez.expensetracker.service.TransactionService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        User user = (User) authentication.getPrincipal();
        return transactionService.getTransactions(user.getId());
    }
}
