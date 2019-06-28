## 1 获取当前最新区块

method：GET  
url: /block/getRecentBlocks

responose:
```json
[
    {
        "height": 580770,
        "time": "2019-06-15T00:32:05.817+0000",
        "blockhash": "00000000000000000025c889729b9f97cb3fc683742608fd61c7e481a7e2c951",
        "size": 1225.464,
        "transacation": 2867,
        "miner": "SlushPool"
    },
    {
        "height": 580769,
        "time": "2019-06-15T00:32:05.817+0000",
        "blockhash": "000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb",
        "size": 1773.224,
        "transacation": 538,
        "miner": "AntPool"
    }
]
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    height|   Integer |  区块高度 |
|    time|   Date |  出块时间 |
|    blockhash|   String |  区块hash |
|    size|   Integer |  区块大小 |
|    transacation|   Integer |  交易数量 |
|    miner|   String |  矿工 |


## 2 根据区块hash获取区块详情

method：GET  
url: /block/getByBlockhash?blockhash={blockhash}

responose:
```json
{
    "blockhash": "00000000000000000006a0673f90d900aefe5f7bef705f7dbdabe9b7077e06dd",
    "height": 580768,
    "time": "2019-06-15T00:52:24.048+0000",
    "size": 1703.051,
    "difficulty": 7409399249090.25,
    "weight": 3992.567,
    "nextBlock": "000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb",
    "prevBlock": "00000000000000000001a138975ccd1ff91e4c7af0ce0d8b6b45ff806a6b7abe",
    "transacation": 948
}
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块hash |
|    height|   Integer |  出块高度 |
|    time|   Date |  区块时间 |
|    size|   Double |  区块大小 |
|    difficulty|   Double |  困难度数 |
|    weight|   Double |  区块重量 |
|    nextBlock|   String |  下一个hash |
|    prevBlock|   String |  上一个hash |
|    transacation|   Integer |  交易数量 |


## 3 根据区块高度获取区块详情

method：GET  
url: /block/getByHeight?height={height}

responose:
```json
{
    "blockhash": "00000000000000000006a0673f90d900aefe5f7bef705f7dbdabe9b7077e06dd",
    "height": 580768,
    "time": "2019-06-15T00:52:24.048+0000",
    "size": 1703.051,
    "difficulty": 7409399249090.25,
    "weight": 3992.567,
    "nextBlock": "000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb",
    "prevBlock": "00000000000000000001a138975ccd1ff91e4c7af0ce0d8b6b45ff806a6b7abe",
    "transacation": 948
}
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块hash |
|    height|   Integer |  出块高度 |
|    time|   Date |  区块时间 |
|    size|   Double |  区块大小 |
|    difficulty|   Double |  困难度数 |
|    weight|   Double |  区块重量 |
|    nextBlock|   String |  下一个hash |
|    prevBlock|   String |  上一个hash |
|    transacation|   Integer |  交易数量 |


## 4 获取当前最新交易

method：GET  
url: /transacation/getRecentTransacation

responose:
```json
{
    "transactionHash": "c09a5947c95d4ce714b82529eb8289b17f8395087bc8085cbcab9e6c3f194bfa",
    "time": "2019-06-15T02:29:30.586+0000",
    "amount": 0.02423692
}
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    transactionHash|   String |  交易hash |
|    time|   Date |  交易时间 |
|    amount|   double |  交易价格 |




