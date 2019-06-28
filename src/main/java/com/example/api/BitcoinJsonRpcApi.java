package com.example.api;

import com.alibaba.fastjson.JSONObject;

public interface BitcoinJsonRpcApi {
    JSONObject getBlockchainInfo() throws Throwable;

    JSONObject getBlockByHash(String blockhash) throws Throwable;

    JSONObject getTransactionById(String txid) throws Throwable;

    String getBlockHashByHeight(Integer height) throws Throwable;
}
