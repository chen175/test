package com.example.scheduler;

import com.example.controller.BlockController;
import com.example.dto.BlockListDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlockScheduler {
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Autowired
//    private BlockController blockController;
//    @Autowired
//    private SimpMessagingTemplate simpMessagingTemplate;
//    @Scheduled(fixedRate = 1000*60*10)
//    public void synvblock() throws Throwable {
//        logger.info("begin to sync block");
//        List<BlockListDto> recentBlocks = blockController.getRecentBlocks();
//        simpMessagingTemplate.convertAndSend("/mytopic/greetings",recentBlocks);
//    }
}
