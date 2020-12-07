CREATE TABLE `roles` (
`roleid` int(11) NOT NULL AUTO_INCREMENT,
`rolename` varchar(30) DEFAULT NULL,
`user_id` int(11) DEFAULT NULL, PRIMARY KEY (`roleid`),
UNIQUE KEY `roles_fk` (`user_id`) USING BTREE,
CONSTRAINT `roles_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;