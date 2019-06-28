package com.example.dao;

import com.example.dto.TransacationDto;
import com.example.po.Transacation;

import java.util.List;

public interface TransacationMapper {
    int deleteByPrimaryKey(String txhash);

    int insert(Transacation record);

    int insertSelective(Transacation record);

    Transacation selectByPrimaryKey(String txhash);

    int updateByPrimaryKeySelective(Transacation record);

    int updateByPrimaryKey(Transacation record);

    List<TransacationDto> getRecentTransacation();

    Transacation getTransacationByHash(String hash);

}