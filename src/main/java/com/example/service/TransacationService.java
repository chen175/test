package com.example.service;

import com.example.dto.TransacationDto;
import com.example.po.Transacation;

import java.util.List;

public interface TransacationService {
    List<TransacationDto> getRecentTransacation();

    Transacation getTransacationByHash(String hash);
}
