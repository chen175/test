package com.example.scheduler;

import com.example.controller.BlockController;
import com.example.controller.Temp2Controller;
import com.example.dto.BlockListDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class BitcoinScheduler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Temp2Controller temp2Controller;
    @Autowired
    private BlockController blockController;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Scheduled(fixedRate = 3000)
    public void synData() throws Throwable {
        logger.info("begin to sync db");
        String tempblockhash = blockController.getEndBlockHash();
        temp2Controller.test(tempblockhash);
        List<BlockListDto> recentBlocks = blockController.getRecentBlocks();
        simpMessagingTemplate.convertAndSend("/mytopic/greetings",recentBlocks);
    }

}
