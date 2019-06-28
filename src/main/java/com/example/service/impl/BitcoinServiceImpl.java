package com.example.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.api.BitcoinJsonRpcApi;
import com.example.controller.BlockController;
import com.example.controller.DetailController;
import com.example.controller.TransacationController;
import com.example.dao.DetallMapper;
import com.example.dao.TransacationMapper;
import com.example.enumeration.TxDetailType;
import com.example.po.Detall;
import com.example.po.Transacation;
import com.example.service.BitcoinService;
import com.example.api.BitcoinRestApi;
import com.example.dao.BlockMapper;
import com.example.po.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedHashMap;

@Service
public class BitcoinServiceImpl implements BitcoinService {
    @Autowired
    private BitcoinRestApi bitcoinRestApi;
    @Autowired
    private BlockMapper blockMapper;
    @Autowired
    private TransacationMapper transacationMapper;
    @Autowired
    private DetallMapper detailMapper;
    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;
    @Autowired
    private BlockController blockController;
    @Autowired
    private TransacationController transactionController;
    @Autowired
    private DetailController detailController;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @Async
    public void ssyncBlockChainFromHash(String blockhash) throws Throwable {
        logger.info("begin to sync blockchain from {}", blockhash);
        String tempBlockhash = blockhash;
        while (tempBlockhash != null && !tempBlockhash.isEmpty()) {
            tempBlockhash = syncBlock(tempBlockhash);
        }
        logger.info("end sync blockchain ");
    }

    @Override
    @Transactional
    public String syncBlock(String blockhash) throws Throwable {
        logger.info("begin to sync block from {}", blockhash);
        JSONObject blockByHash = bitcoinRestApi.getBlockByHash(blockhash);
        Block block = new Block();
        block.setBlockhash(blockByHash.getString("hash"));
        block.setHeight(blockByHash.getInteger("height"));
        Long timestamp = blockByHash.getLong("time");
        Date time = new Date(timestamp * 1000);
        block.setTime(time);
        block.setSize(blockByHash.getInteger("size"));
        block.setDifficulty(blockByHash.getDouble("difficulty"));
        block.setWeight(blockByHash.getFloat("weight"));
        block.setNextBlock(blockByHash.getString("nextblockhash"));
        block.setPrevBlock(blockByHash.getString("previousblockhash"));
        block.setTransacation(blockByHash.getInteger("nTx"));
        Integer confirmations = blockByHash.getInteger("confirmations");
        Block byBlockhash = blockController.getByBlockhash(blockhash);
        if (byBlockhash != null) {
            if (byBlockhash.getNextBlock() == null) {
                blockMapper.updateByPrimaryKey(block);
            }
        } else {
            blockMapper.insertSelective(block);
        }
        //tx
        JSONArray tx = blockByHash.getJSONArray("tx");
        for (Object o : tx) {
            JSONObject jsonObject = new JSONObject((LinkedHashMap) o);
            syncTx(jsonObject, blockhash, time, confirmations);
        }
        logger.info("end sync block");
        return block.getNextBlock();
    }

    @Override
    @Transactional
    public void syncTx(JSONObject txJson, String blockhash, Date time, Integer confirmations) throws Throwable {
        Transacation transacation = new Transacation();
        String txid = txJson.getString("txid");
        transacation.setTxhash(txid);
        transacation.setTime(time);
        transacation.setBlockhash(blockhash);
        transacation.setSize(txJson.getInteger("size"));
        transacation.setWeight(txJson.getFloat("weight"));
        transacation.setConfirmations(confirmations);
        Transacation transacationByHash = transactionController.getTransacationByHash(txid);
        if (transacationByHash == null) {
            transacationMapper.insertSelective(transacation);
            syncTxDetail(txJson, txid);
        }
    }

    @Override
    @Transactional
    public void syncTxDetail(JSONObject txjson, String txid) throws Throwable {
        JSONArray vout = txjson.getJSONArray("vout");
        syncDetailvout(vout, txid);
        JSONArray vin = txjson.getJSONArray("vin");
        syncDetailvin(vin, txid);
    }

    @Override
    @Transactional
    public void syncDetailvout(JSONArray vouts, String txid) {
        for (Object vout : vouts) {
            JSONObject jsonObject = new JSONObject((LinkedHashMap) vout);
            Detall detail = new Detall();
            detail.setTxhash(txid);
            detail.setAmount(-jsonObject.getDouble("value"));
            detail.setType((byte) TxDetailType.Receive.ordinal());
            JSONObject scriptPubKey = jsonObject.getJSONObject("scriptPubKey");
            JSONArray address = scriptPubKey.getJSONArray("addresses");
            if (address != null) {
                String string = address.getString(0);
                detail.setAdress(string);
//                if (detailController.getDetailByAddress(address.getString(0)).size() == 0) {
//                    detailMapper.updateByPrimaryKey(detail);
//                } else {
//                    detailMapper.insertSelective(detail);
//                }
            }
            detailMapper.insertSelective(detail);
        }
    }

    @Override
    public void syncDetailvin(JSONArray vins, String txid) throws Throwable {
        for (Object vin : vins) {
            JSONObject jsonObject = new JSONObject((LinkedHashMap) vin);
            String vintxid = jsonObject.getString("txid");
            Integer n = jsonObject.getInteger("vout");
            if (vintxid != null) {
                JSONObject transactionById = bitcoinJsonRpcApi.getTransactionById(vintxid);
                JSONArray vout = transactionById.getJSONArray("vout");
                JSONObject jsonObject1 = vout.getJSONObject(n);
                Detall detail = new Detall();
                detail.setAmount(jsonObject1.getDouble("value"));
                detail.setType((byte) TxDetailType.Send.ordinal());
                JSONObject scriptPubKey = jsonObject1.getJSONObject("scriptPubKey");
                JSONArray addresses = scriptPubKey.getJSONArray("addresses");
                if (addresses != null) {
                    detail.setAdress(addresses.getString(0));
//                    if (detailController.getDetailByAddress(addresses.getString(0)).size() == 0) {
//                        detailMapper.updateByPrimaryKey(detail);
//                    } else {
//                        detailMapper.insertSelective(detail);
//                    }
                }
                detailMapper.insertSelective(detail);

            }
        }

    }


}
