SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for transaction
-- ----------------------------
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction`
(
  `txhash`        char(64) NOT NULL,
  `time`          datetime,
  `amount`        double,
  `size`          int,
  `weight`        float,
  `block`         int,
  `visualize`     varchar ,
  `total_input`   double,
  `total_output`  double,
  `fees`          double ,
  `fee_per_byte`  double,
  `fee_per_weight_unit` double ,
  `blockhash`     char(64) NOT NULL,
  `confirmations` int,
  PRIMARY KEY (`txhash`),
  index `idx_time` (`time`),
  index `idx_blockhash` (`blockhash`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
