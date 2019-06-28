package com.example.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.api.BitcoinJsonRpcApi;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

@Component
public class BitcoinJsonRpcApiImpl implements BitcoinJsonRpcApi {
    private JsonRpcHttpClient jsonRpcHttpClient;

    public BitcoinJsonRpcApiImpl(@Value("${bitcoin.jsonrpc.username}") String username,
                                 @Value("${bitcoin.jsonrpc.passsword}") String password,
                                 @Value("${bitcoin.jsonrpc.url}") String url) throws MalformedURLException {
        HashMap<String, String> headers = new HashMap<>();
        String authStrOrig = String.format("%s:%s", username, password);
        String authStr = Base64.getEncoder().encodeToString(authStrOrig.getBytes());
        String authStrResult = String.format("Basic %s", authStr);
        headers.put("Authorization", authStrResult);
        jsonRpcHttpClient = new JsonRpcHttpClient(new URL(url), headers);
    }

    @Override
    public JSONObject getBlockchainInfo() throws Throwable {
        JSONObject getblockchaininfo = jsonRpcHttpClient.invoke("getblockchaininfo", new Object[]{}, JSONObject.class);
        return getblockchaininfo;
    }

    @Override
    public JSONObject getBlockByHash(String blockhash) throws Throwable {
        JSONObject jsonObject = jsonRpcHttpClient.invoke("getblock", new Object[]{blockhash}, JSONObject.class);
        return jsonObject;
    }

    @Override
    public JSONObject getTransactionById(String txid) throws Throwable {
        JSONObject jsonObject = jsonRpcHttpClient.invoke("getrawtransaction", new Object[]{txid, true}, JSONObject.class);
        return jsonObject;
    }

    @Override
    public String getBlockHashByHeight(Integer height) throws Throwable {
        String getblockhash = jsonRpcHttpClient.invoke("getblockhash", new Object[]{height}, String.class);
        return getblockhash;
    }
}
