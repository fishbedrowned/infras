
CREATE TABLE `AdminLogin` (
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `Menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL COMMENT '菜单名称',
  `link` varchar(200) NOT NULL COMMENT '菜单链接',
  `parent` int(11) NOT NULL COMMENT '父节点，0为以及菜单',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE `unqName` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';

CREATE TABLE `RoleMenus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NOT NULL COMMENT '角色Id',
  `menuId` int(11) NOT NULL COMMENT '菜单Id',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE `unqRoleMenu` (`roleId`,`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单表';

CREATE TABLE `Roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL COMMENT '角色名称',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE `unqName` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

CREATE TABLE `AdminRole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginId` int(11) NOT NULL COMMENT '用户Id',
  `roleId` int(11) NULL COMMENT '角色Id',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE `unqLoginIdRoleId` (`loginId`, `roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表';
