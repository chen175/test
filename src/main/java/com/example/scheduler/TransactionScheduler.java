package com.example.scheduler;

import com.example.controller.TransacationController;
import com.example.dto.TransacationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TransactionScheduler {
    @Autowired
    private TransacationController transacationController;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Scheduled(fixedRate = 2000)
    public void syncTransaction(){
        logger.info("begin to sync transaction");
        List<TransacationDto> recentTransacation = transacationController.getRecentTransacation();
        simpMessagingTemplate.convertAndSend("/mytopic/greetings2",recentTransacation);
    }
}
