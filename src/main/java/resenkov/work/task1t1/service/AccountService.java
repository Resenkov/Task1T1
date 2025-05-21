package resenkov.work.task1t1.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import resenkov.work.task1t1.entity.Account;
import resenkov.work.task1t1.repository.AccountRepository;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    private final ObjectMapper objectMapper;

    public Page<Account> getAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    public Account getOne(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        return accountOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));
    }

    public List<Account> getMany(List<Long> ids) {
        return accountRepository.findAllById(ids);
    }

    public Account create(Account account) {
        return accountRepository.save(account);
    }

    public Account patch(Long id, JsonNode patchNode) throws IOException {
        Account account = accountRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        objectMapper.readerForUpdating(account).readValue(patchNode);

        return accountRepository.save(account);
    }

    public List<Long> patchMany(List<Long> ids, JsonNode patchNode) throws IOException {
        Collection<Account> accounts = accountRepository.findAllById(ids);

        for (Account account : accounts) {
            objectMapper.readerForUpdating(account).readValue(patchNode);
        }

        List<Account> resultAccounts = accountRepository.saveAll(accounts);
        return resultAccounts.stream()
                .map(Account::getId)
                .toList();
    }

    public Account delete(Long id) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account != null) {
            accountRepository.delete(account);
        }
        return account;
    }

    public void deleteMany(List<Long> ids) {
        accountRepository.deleteAllById(ids);
    }
}
