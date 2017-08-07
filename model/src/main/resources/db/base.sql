
create database infras DEFAULT CHARSET=utf8mb4;

-- Demo表
-- 注意创建表的几个要点：
-- 1. 表名、字段简洁明了，少缩写
-- 2. 主键自增
-- 3. 字段、表必须有COMMENT
-- 4. 如果是枚举，写清楚枚举类型
-- 5. 字符格式默认utf8mb4
CREATE TABLE `Greeting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='会议测试';