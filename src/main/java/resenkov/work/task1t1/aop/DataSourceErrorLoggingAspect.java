package resenkov.work.task1t1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import resenkov.work.task1t1.entity.DataSourceErrorLog;
import resenkov.work.task1t1.repository.DataSourceErrorLogRepository;

import java.io.PrintWriter;
import java.io.StringWriter;

@Aspect
@Component
public class DataSourceErrorLoggingAspect {

    private final DataSourceErrorLogRepository logRepo;

    public DataSourceErrorLoggingAspect(DataSourceErrorLogRepository logRepo) {
        this.logRepo = logRepo;
    }

    @Around("@annotation(resenkov.work.task1t1.aop.LogDataError)")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Object logErrors(ProceedingJoinPoint pjp) throws Throwable {

        try {
            return pjp.proceed();
        } catch (Exception ex) {
            MethodSignature sig = (MethodSignature) pjp.getSignature();
            DataSourceErrorLog log = new DataSourceErrorLog();
            log.setMessage(ex.getMessage());
            log.setStackTrace(getStackTrace(ex));
            log.setSignatureMethod(sig.getDeclaringTypeName() + "." + sig.getName());
            logRepo.save(log);
            throw ex;
        }
    }

    private String getStackTrace(Exception ex) {
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}
