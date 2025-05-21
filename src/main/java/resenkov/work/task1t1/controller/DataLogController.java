package resenkov.work.task1t1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import resenkov.work.task1t1.entity.DataSourceErrorLog;
import resenkov.work.task1t1.repository.DataSourceErrorLogRepository;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class DataLogController {
    private final DataSourceErrorLogRepository dataSourceErrorLogRepository;

    public DataLogController(DataSourceErrorLogRepository dataSourceErrorLogRepository) {
        this.dataSourceErrorLogRepository = dataSourceErrorLogRepository;
    }

    @GetMapping
    public ResponseEntity<List<DataSourceErrorLog>> findAll(){
        return ResponseEntity.ok(dataSourceErrorLogRepository.findAll());
    }
}
