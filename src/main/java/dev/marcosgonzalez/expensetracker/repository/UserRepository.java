package dev.marcosgonzalez.expensetracker.repository;

import dev.marcosgonzalez.expensetracker.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsernameIgnoreCase(String email);

    boolean existsByUsernameIgnoreCaseOrEmailIgnoreCase(String username, String password);
}
