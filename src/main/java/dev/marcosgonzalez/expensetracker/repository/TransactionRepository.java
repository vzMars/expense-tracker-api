package dev.marcosgonzalez.expensetracker.repository;

import dev.marcosgonzalez.expensetracker.dto.TransactionInfo;
import dev.marcosgonzalez.expensetracker.model.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    @Query(value = "SELECT new dev.marcosgonzalez.expensetracker.dto.TransactionInfo(t.id, t.title, t.amount, " +
            "t.transactionDate, t.description, t.user.id, t.category.id, t.category.name, t.category.type) " +
            "FROM transactions t WHERE t.user.id = :id")
    List<TransactionInfo> findTransactionsByUserId(Integer id);
}
