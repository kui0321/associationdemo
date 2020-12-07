CREATE TABLE `orders` (
`orderid` int(11) NOT NULL AUTO_INCREMENT,
`orderprice` double DEFAULT NULL,
`user_id` int(11) DEFAULT NULL, PRIMARY KEY (`orderid`),
KEY `orders_fk` (`user_id`),
CONSTRAINT `orders_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;