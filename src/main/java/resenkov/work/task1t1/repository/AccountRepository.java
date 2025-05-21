package resenkov.work.task1t1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import resenkov.work.task1t1.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}