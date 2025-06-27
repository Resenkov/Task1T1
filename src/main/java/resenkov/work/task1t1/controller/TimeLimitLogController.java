package resenkov.work.task1t1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import resenkov.work.task1t1.entity.TimeLimitLog;
import resenkov.work.task1t1.service.TimeLimitLogService;

import java.util.List;

@RestController
@RequestMapping("/time")
public class TimeLimitLogController {
    private final TimeLimitLogService timeLimitLogService;

    @Autowired
    public TimeLimitLogController(TimeLimitLogService timeLimitLogService) {
        this.timeLimitLogService = timeLimitLogService;
    }

    @GetMapping
    public ResponseEntity<List<TimeLimitLog>> findAll(){
        return ResponseEntity.ok(timeLimitLogService.findAll());
    }
}
