package resenkov.work.task1t1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import resenkov.work.task1t1.entity.Account;
import resenkov.work.task1t1.entity.Transaction;
import resenkov.work.task1t1.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAll(){
        return ResponseEntity.ok(transactionService.findAll());
    }

    @PostMapping("get/{id}")
    public ResponseEntity<Transaction> getById(Long id){
        return ResponseEntity.ok(transactionService.getById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Transaction> addAccount(Transaction  transaction){
        return ResponseEntity.ok(transactionService.addTransaction(transaction));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteById(Long id){
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Transaction> updateAccount(Transaction transaction){
        return ResponseEntity.ok(transactionService.updateTransaction(transaction));
    }
}
