
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

-- Session 处理

CREATE TABLE `PhoneCode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) NOT NULL COMMENT '手机号码。',
  `code` varchar(10) NOT NULL COMMENT '验证码。',
  `isRetry` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否重新获取',
  `triedTimes` int(1) NOT NULL DEFAULT '0' COMMENT '验证码尝试次数',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间。',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unqPhone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='手机验证码。';