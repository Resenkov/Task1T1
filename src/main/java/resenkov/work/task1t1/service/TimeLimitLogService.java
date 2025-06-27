package resenkov.work.task1t1.service;

import org.springframework.stereotype.Service;
import resenkov.work.task1t1.entity.TimeLimitLog;
import resenkov.work.task1t1.repository.TimeLimitLogRepository;

import java.util.List;

@Service
public class TimeLimitLogService {
    private final TimeLimitLogRepository timeLimitLogRepository;

    public TimeLimitLogService(TimeLimitLogRepository timeLimitLogRepository) {
        this.timeLimitLogRepository = timeLimitLogRepository;
    }

    public List<TimeLimitLog> findAll(){
        return timeLimitLogRepository.findAll();
    }
}
