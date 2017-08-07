
-- 登录表

CREATE TABLE `Login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(64) NOT NULL COMMENT '密码',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名字',
  `thumbnail` varchar(500) NOT NULL DEFAULT '' COMMENT '用户头像',
  `gender` tinyint(4) NOT NULL DEFAULT '-1' COMMENT '用户性别',
  `birth` datetime DEFAULT NULL COMMENT '用户生日',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '账号状态',
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unqPhone` (`phone`),
  UNIQUE KEY `unqEmail` (`email`(32))
) ENGINE=InnoDB CHARSET=utf8mb4;