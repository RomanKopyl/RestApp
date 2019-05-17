package newProject.controllers.restControllers;

import newProject.domain.Transaction;
import newProject.domain.TransactionState;
import newProject.domain.User;
import newProject.dto.RequestTransactionAmountDto;
import newProject.dto.RequestTransactionStateDto;
import newProject.dto.ResponseTransactionDto;
import newProject.repos.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {
    @Autowired
    private TransactionRepo transactionRepo;

    @GetMapping
    public Iterable<ResponseTransactionDto> list() {

        Iterable<Transaction> transactions = transactionRepo.findAll();

        List<ResponseTransactionDto> responseList = new ArrayList<ResponseTransactionDto>();

        for (Transaction transactionFromDb : transactions) {

            ResponseTransactionDto response = new ResponseTransactionDto(
                    transactionFromDb.getId(),
                    transactionFromDb.getDate(),
                    transactionFromDb.getAmount(),
                    transactionFromDb.getState());

            responseList.add(response);

        } return responseList;
    }

    @GetMapping("{id}")
    public ResponseTransactionDto getOne(@PathVariable Integer id) throws Exception {

        Transaction transactionFromDb = getTransaction(id);

        ResponseTransactionDto response = new ResponseTransactionDto(
                transactionFromDb.getId(),
                transactionFromDb.getDate(),
                transactionFromDb.getAmount(),
                transactionFromDb.getState());

        return response;
    }

    private Transaction getTransaction(@PathVariable Integer id) throws Exception {

        Optional<Transaction> transaction = transactionRepo.findById(id);

        if (!transaction.isPresent()) {
            throw new Exception("Transaction missing");
        }

        return transaction.get();
//        return transactionRepo.findById(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Transaction create(@RequestBody RequestTransactionAmountDto transaction, @AuthenticationPrincipal User user) {

        Transaction newTransaction = new Transaction(new Date(), transaction.getAmount(), TransactionState.ONCHECK, user);
        transactionRepo.save(newTransaction);

        return newTransaction;
    }

    @PutMapping("{id}")
    public ResponseTransactionDto update(@PathVariable Integer id, @RequestBody RequestTransactionStateDto transaction) throws Exception {

        Transaction transactionFromDb = getTransaction(id);

        transactionFromDb.setState((transaction.getTransactionState()));

        ResponseTransactionDto response = new ResponseTransactionDto(
                transactionFromDb.getId(),
                transactionFromDb.getDate(),
                transactionFromDb.getAmount(),
                transactionFromDb.getState());

        transactionRepo.save(transactionFromDb);

        return response;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {

        transactionRepo.deleteById(id);
    }
}
