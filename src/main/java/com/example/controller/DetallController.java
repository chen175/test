package com.example.controller;

import com.example.dao.DetallMapper;
import com.example.po.Detall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detall")

public class DetallController {
    @Autowired
    private DetallMapper detailMapper;

    @RequestMapping("/getDetallByHash")
    public Detall getDetallByHash(@RequestParam String hash) {
        Detall detall = detailMapper.selectByPrimaryKey(hash);
        return detall;
    }
}
