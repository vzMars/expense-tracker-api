package dev.marcosgonzalez.expensetracker.service;

import dev.marcosgonzalez.expensetracker.dto.TransactionBody;
import dev.marcosgonzalez.expensetracker.dto.TransactionInfo;
import dev.marcosgonzalez.expensetracker.exception.NotFoundException;
import dev.marcosgonzalez.expensetracker.model.Category;
import dev.marcosgonzalez.expensetracker.model.Transaction;
import dev.marcosgonzalez.expensetracker.model.User;
import dev.marcosgonzalez.expensetracker.repository.CategoryRepository;
import dev.marcosgonzalez.expensetracker.repository.TransactionRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;

    public TransactionService(TransactionRepository transactionRepository, CategoryRepository categoryRepository) {
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<TransactionInfo> getTransactions(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return transactionRepository.findTransactionsByUserId(user.getId());
    }

    public TransactionInfo createTransaction(TransactionBody body, Authentication authentication) {
        User user = (User) authentication.getPrincipal();

        Optional<Category> category = categoryRepository.findById(body.getCategoryId());

        if (category.isEmpty()) {
            throw new NotFoundException("Category not found.");
        }

        Transaction transaction = new Transaction(body.getTitle(), body.getAmount(), body.getTransactionDate(),
                body.getDescription(), user, category.get());

        Transaction savedTransaction = transactionRepository.save(transaction);

        return new TransactionInfo(savedTransaction.getId(), savedTransaction.getTitle(), savedTransaction.getAmount(),
                savedTransaction.getTransactionDate(), savedTransaction.getDescription(), savedTransaction.getUser().getId(),
                savedTransaction.getCategory().getId(), savedTransaction.getCategory().getName(), savedTransaction.getCategory().getType());
    }

    public TransactionInfo updateTransaction(Integer id, TransactionBody body, Authentication authentication) {
        User user = (User) authentication.getPrincipal();

        Optional<Transaction> transaction = transactionRepository.findById(id);

        if (transaction.isEmpty() || !transaction.get().getUser().getId().equals(user.getId())) {
            throw new NotFoundException("Transaction not found.");
        }

        Optional<Category> category = categoryRepository.findById(body.getCategoryId());

        if (category.isEmpty()) {
            throw new NotFoundException("Category not found.");
        }

        transaction.get().setTitle(body.getTitle());
        transaction.get().setAmount(body.getAmount());
        transaction.get().setTransactionDate(body.getTransactionDate());
        transaction.get().setDescription(body.getDescription());
        transaction.get().setCategory(category.get());

        Transaction savedTransaction = transactionRepository.save(transaction.get());

        return new TransactionInfo(savedTransaction.getId(), savedTransaction.getTitle(), savedTransaction.getAmount(),
                savedTransaction.getTransactionDate(), savedTransaction.getDescription(), savedTransaction.getUser().getId(),
                savedTransaction.getCategory().getId(), savedTransaction.getCategory().getName(), savedTransaction.getCategory().getType());
    }
}
