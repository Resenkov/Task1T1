package resenkov.work.task1t1.aop;


import jakarta.transaction.Transactional;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import resenkov.work.task1t1.entity.TimeLimitLog;
import resenkov.work.task1t1.repository.TimeLimitLogRepository;

import java.time.LocalDateTime;

@Aspect
@Component
public class MetricAspect {

    private final TimeLimitLogRepository timeLimitLogRepository;
    private final long timeLimit;
    public MetricAspect(TimeLimitLogRepository timeLimitLogRepository,@Value("${app.metric.timeLimit}") long timeLimit) {
        this.timeLimitLogRepository = timeLimitLogRepository;
        this.timeLimit = timeLimit;
    }

    @Around("@annotation(resenkov.work.task1t1.aop.Metric)")
    @Transactional
    public Object check(ProceedingJoinPoint pjp) throws Throwable{
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        long time = end - start;
        if (time > timeLimit) {
            MethodSignature sig = (MethodSignature) pjp.getSignature();
            TimeLimitLog log = new TimeLimitLog();
            System.out.println("Вызван метод:  " + sig.getName() + " и его время выполнения " + time);
            log.setMethodName(sig.getName());
            log.setDuration(time);
            log.setTimestamp(LocalDateTime.now());
            timeLimitLogRepository.save(log);
        }
        return result;
    }
}
