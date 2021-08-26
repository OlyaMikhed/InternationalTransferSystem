package by.mikhed.ITS.repository;

import by.mikhed.ITS.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    Optional<Transaction> findByTransferNumber(Integer transactionNumber);

}
