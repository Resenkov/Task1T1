package resenkov.work.task1t1.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import resenkov.work.task1t1.entity.DataSourceErrorLog;
import resenkov.work.task1t1.repository.DataSourceErrorLogRepository;

import java.util.List;


@Service
@Transactional
public class DataSourceErrorLogService {
    private final DataSourceErrorLogRepository dataSourceErrorLogRepository;

    public DataSourceErrorLogService(DataSourceErrorLogRepository dataSourceErrorLogRepository) {
        this.dataSourceErrorLogRepository = dataSourceErrorLogRepository;
    }

    public List<DataSourceErrorLog> findAll(){
        return dataSourceErrorLogRepository.findAll();
    }
}
