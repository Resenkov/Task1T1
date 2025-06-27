package resenkov.work.task1t1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import resenkov.work.task1t1.entity.TimeLimitLog;

public interface TimeLimitLogRepository extends JpaRepository<TimeLimitLog, Long> {
}