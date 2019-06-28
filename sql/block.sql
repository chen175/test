SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for block
-- ----------------------------
DROP TABLE IF EXISTS `block`;
CREATE TABLE `block`
(
  `blockhash`  char(64) NOT NULL,
  `transactions` int NOT NULL,
  `output_total` double,
  `estimated_transactin_volume` double ,
  `transaction_fees` double ,
  `height`     int NOT NULL,
  `time`       datetime,
  `miner`      varchar ,
  `bits`       int,
  `txSize`     int,
  `version`    varchar ,
  `nonce`      int,
  `block_reward` double,
  `size`       int,
  `difficulty` double,
  `weight`     float,
  `next_block` char(64),
  `prev_block` char(64),
  `merkle_root` char(64),
  PRIMARY KEY (`blockhash`),
  index `idx_height` (`height`),
  index `idx_time` (`time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
