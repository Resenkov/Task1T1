package resenkov.work.task1t1.service;

import org.springframework.stereotype.Service;
import resenkov.work.task1t1.aop.LogDataError;
import resenkov.work.task1t1.aop.Metric;
import resenkov.work.task1t1.repository.AccountRepository;

@Service
public class ErrorService {
    private final AccountRepository accountRepo;
    public ErrorService(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    @LogDataError
    public void triggerError() {
        accountRepo.save(null);
    }

    @Metric
    public void slow() throws InterruptedException {
        Thread.sleep(50);
    }
}
