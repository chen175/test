package com.example.service;

import com.example.dto.BlockListDto;
import com.example.po.Block;

import java.util.List;

public interface BlockService {

    List<BlockListDto> getRecentBlocks();

    Block getBlockByHash(String blockhash);


    Block getBlockByHeight(Integer height);

    Double getBlance(String address);

    Block getEndBlockHash();

}
