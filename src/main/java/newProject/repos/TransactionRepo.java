package newProject.repos;

import newProject.domain.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepo extends CrudRepository<Transaction, Integer> {

//    List<Transaction> findByAuthor(String username);
}
