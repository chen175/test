package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.api.BitcoinJsonRpcApi;
import com.example.po.Detall;
import com.example.service.BitcoinService;
import com.example.api.BitcoinRestApi;
import com.example.dao.BlockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/temp2")
@RestController
public class Temp2Controller {
    @Autowired
    private BitcoinRestApi bitcoinRestApi;
    @Autowired
    private BlockMapper blockMapper;
    @Autowired
    private BitcoinService bitcoinService;
    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;
    @Autowired
    private DetailController detailController;


    @GetMapping("/test")
    public String test(String tempBlockhash) throws Throwable {
//        HashMap<String, String> headers = new HashMap<>();
//        String authStrOrig = "chensir:123456";
//        String authStr = Base64.getEncoder().encodeToString(authStrOrig.getBytes());
//        String authStrResult = String.format("Basic %s",authStr);
//        headers.put("Authorization",authStrResult);
//
//        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL("http://localhost:18332"),headers);
//
//        JSONObject user = client.invoke("getblockchaininfo", new Object[]{}, JSONObject.class);
//        JSONObject blockChainInfo = bitcoinRestApi.getBlockChainInfo();
//        JSONObject blockByHash = bitcoinRestApi.getBlockByHash("0000000000000453e8ca7b4407b35b5dddb6eda44a163f97215a2fd6b545285f");
//        JSONObject transaction = bitcoinRestApi.getTransaction("715e13120743d218cb4c6842ab9883bf5482802b3f190fac2e6c43228cdb5cdf");
//        List<Detall> mtbBWgKGUMbqLTe8QZeBtCBYe1wgB7EzTM = detailController.getDetailByAddress("mtbBWgKGUMbqLTe8QZeBtCBYe1wgB7EzTM");
        bitcoinService.ssyncBlockChainFromHash(tempBlockhash);
//        JSONObject transactionById = bitcoinJsonRpcApi.getTransactionById("f0e71174b0b1438bfd11645c82c887d3c4fdff00985c2e9224c516751cc20142");
        return null;
    }


}
