package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.api.BitcoinRestApi;
import com.example.dto.BlockGetDto;
import com.example.po.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/bitcoin")
@CrossOrigin
public class SearchController {
    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @RequestMapping("/search")
    public Object search(@RequestParam(required = false) String data) throws Exception {
        if (data.length() == 34 || data.length() == 35) {

        } else if (data.length() == 64) {
            try {
                JSONObject byBlockhash = bitcoinRestApi.getBlockByHash(data);
                System.out.println(byBlockhash);
                if (byBlockhash != null) {
                    Block block = new Block();
                    block.setBlockhash(byBlockhash.getString("hash"));
                    block.setHeight(byBlockhash.getInteger("height"));
                    Long timestamp = byBlockhash.getLong("time");
                    Date time = new Date(timestamp * 1000);
                    block.setTime(time);
                    block.setSize(byBlockhash.getInteger("size"));
                    block.setDifficulty(byBlockhash.getDouble("difficulty"));
                    block.setWeight(byBlockhash.getFloat("weight"));
                    block.setNextBlock(byBlockhash.getString("nextblockhash"));
                    block.setPrevBlock(byBlockhash.getString("previousblockhash"));
                    block.setTransacation(byBlockhash.getInteger("nTx"));
                    Integer confirmations = byBlockhash.getInteger("confirmations");
                    return block;
                }
            } catch (Exception e) {
                throw new Exception("Please enter an address, transaction hash, block height or hash");
            }
        } else if (data.length() <= 7) {

            try {
                int height = Integer.parseInt(data);
                JSONObject byHeight = bitcoinRestApi.getBlockByHeight(height);
//                bitcoinRestApi.getBlockByHash(byHeight.getString(""));
                System.out.println(byHeight);
                String blockhash = byHeight.getString("blockhash");
                JSONObject byBlockhash = bitcoinRestApi.getBlockByHash(blockhash);
                if (byBlockhash != null) {
                    Block block = new Block();
                    block.setBlockhash(byBlockhash.getString("hash"));
                    block.setHeight(byBlockhash.getInteger("height"));
                    Long timestamp = byBlockhash.getLong("time");
                    Date time = new Date(timestamp * 1000);
                    block.setTime(time);
                    block.setSize(byBlockhash.getInteger("size"));
                    block.setDifficulty(byBlockhash.getDouble("difficulty"));
                    block.setWeight(byBlockhash.getFloat("weight"));
                    block.setNextBlock(byBlockhash.getString("nextblockhash"));
                    block.setPrevBlock(byBlockhash.getString("previousblockhash"));
                    block.setTransacation(byBlockhash.getInteger("nTx"));
                    Integer confirmations = byBlockhash.getInteger("confirmations");
                    return block;
                }
            } catch (Exception e) {
                throw new Exception("Please enter an address, transaction hash, block height or hash");
            }
        } else {
            throw new Exception("Please enter an address, transaction hash, block height or hash");
        }
        return null;
    }

}
