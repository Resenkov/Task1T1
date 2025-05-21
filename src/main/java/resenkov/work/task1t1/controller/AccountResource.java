package resenkov.work.task1t1.controller;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.*;
import resenkov.work.task1t1.entity.Account;
import resenkov.work.task1t1.service.AccountService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountResource {

    private final AccountService accountService;

    @GetMapping
    public PagedModel<Account> getAll(Pageable pageable) {
        Page<Account> accounts = accountService.getAll(pageable);
        return new PagedModel<>(accounts);
    }

    @GetMapping("/{id}")
    public Account getOne(@PathVariable Long id) {
        return accountService.getOne(id);
    }

    @GetMapping("/by-ids")
    public List<Account> getMany(@RequestParam List<Long> ids) {
        return accountService.getMany(ids);
    }

    @PostMapping
    public Account create(@RequestBody Account account) {
        return accountService.create(account);
    }

    @PatchMapping("/{id}")
    public Account patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return accountService.patch(id, patchNode);
    }

    @PatchMapping
    public List<Long> patchMany(@RequestParam List<Long> ids, @RequestBody JsonNode patchNode) throws IOException {
        return accountService.patchMany(ids, patchNode);
    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable Long id) {
        return accountService.delete(id);
    }

    @DeleteMapping
    public void deleteMany(@RequestParam List<Long> ids) {
        accountService.deleteMany(ids);
    }
}
