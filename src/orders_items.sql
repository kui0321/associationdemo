CREATE TABLE `orders_items` (
`order_id` int(11) NOT NULL,
`item_id` int(11) NOT NULL,
PRIMARY KEY (`order_id`,`item_id`),
KEY `order_item_fk2` (`item_id`),
CONSTRAINT `order_item_fk1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`orderid`),
CONSTRAINT `order_item_fk2` FOREIGN KEY (`item_id`) REFERENCES `items` (`itemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
