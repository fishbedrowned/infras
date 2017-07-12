# 简介

## 模块划分

### 基础模块

- common：共通内容
- model：数据模块
- services：包括所有的业务逻辑

### 应用模块

- api：移动端Api
- admin：后台管理
- web：根据需要再添加
- 可以依赖基础模块

### 相关资料地址

- [mybatis](http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)

### 关于配置文件

- api/admin增加了application-local.properties文件，不会被提交，本地使用在项目启动里面设置active profiles为local

### TODO事项

- 优化log的打印