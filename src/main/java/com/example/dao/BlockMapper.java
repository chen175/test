package com.example.dao;

import com.example.dto.BlockListDto;
import com.example.po.Block;

import java.util.List;

public interface BlockMapper {
    int deleteByPrimaryKey(String blockhash);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(String blockhash);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    List<BlockListDto> selectRecentBlocks();

    Block getBlockByHash(String blockhash);

    Block getBlockByHeight(Integer height);

    Double getBlance(String address);

    Block getEndBlockHash();
}