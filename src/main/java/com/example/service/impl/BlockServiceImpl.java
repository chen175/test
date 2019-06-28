package com.example.service.impl;

import com.example.dao.BlockMapper;
import com.example.dto.BlockListDto;
import com.example.po.Block;
import com.example.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    private BlockMapper blockMapper;

    @Override
    public List<BlockListDto> getRecentBlocks() {
        List<BlockListDto> blockListDtos = blockMapper.selectRecentBlocks();
        return blockListDtos;
    }

    @Override
    public Block getBlockByHash(String blockhash) {
        return blockMapper.getBlockByHash(blockhash);
    }

    @Override
    public Block getBlockByHeight(Integer height) {
        return blockMapper.getBlockByHeight(height);
    }

    @Override
    public Double getBlance(String address) {
        return blockMapper.getBlance(address);
    }

    @Override
    public Block getEndBlockHash() {
        return blockMapper.getEndBlockHash();
    }
}
