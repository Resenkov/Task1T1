package resenkov.work.task1t1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import resenkov.work.task1t1.entity.Account;
import resenkov.work.task1t1.repository.AccountRepository;
import resenkov.work.task1t1.service.AccountService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddAccount() {
        Account account = new Account();
        when(accountRepository.save(account)).thenReturn(account);

        Account result = accountService.addAccount(account);
        assertNotNull(result);
        verify(accountRepository, times(1)).save(account);
    }

    @Test
    void testUpdateAccount() {
        Account account = new Account();
        when(accountRepository.save(account)).thenReturn(account);

        Account result = accountService.updateAccount(account);
        assertNotNull(result);
        verify(accountRepository, times(1)).save(account);
    }

    @Test
    void testDeleteAccount() {
        Long id = 1L;
        doNothing().when(accountRepository).deleteById(id);

        accountService.deleteAccount(id);
        verify(accountRepository, times(1)).deleteById(id);
    }

    @Test
    void testFindAll() {
        List<Account> accounts = Arrays.asList(new Account(), new Account());
        when(accountRepository.findAll()).thenReturn(accounts);

        List<Account> result = accountService.findAll();
        assertEquals(2, result.size());
        verify(accountRepository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        Long id = 1L;
        Account account = new Account();
        when(accountRepository.getReferenceById(id)).thenReturn(account);

        Account result = accountService.getById(id);
        assertNotNull(result);
        verify(accountRepository, times(1)).getReferenceById(id);
    }
}
