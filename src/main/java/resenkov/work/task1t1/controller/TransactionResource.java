package resenkov.work.task1t1.controller;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.*;
import resenkov.work.task1t1.entity.Transaction;
import resenkov.work.task1t1.service.TransactionService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionResource {

    private final TransactionService transactionService;

    @GetMapping
    public PagedModel<Transaction> getAll(Pageable pageable) {
        Page<Transaction> transactions = transactionService.getAll(pageable);
        return new PagedModel<>(transactions);
    }

    @GetMapping("/{id}")
    public Transaction getOne(@PathVariable Long id) {
        return transactionService.getOne(id);
    }

    @GetMapping("/by-ids")
    public List<Transaction> getMany(@RequestParam List<Long> ids) {
        return transactionService.getMany(ids);
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) {
        return transactionService.create(transaction);
    }

    @PatchMapping("/{id}")
    public Transaction patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return transactionService.patch(id, patchNode);
    }

    @PatchMapping
    public List<Long> patchMany(@RequestParam List<Long> ids, @RequestBody JsonNode patchNode) throws IOException {
        return transactionService.patchMany(ids, patchNode);
    }

    @DeleteMapping("/{id}")
    public Transaction delete(@PathVariable Long id) {
        return transactionService.delete(id);
    }

    @DeleteMapping
    public void deleteMany(@RequestParam List<Long> ids) {
        transactionService.deleteMany(ids);
    }
}
