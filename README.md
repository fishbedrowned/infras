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
- mybatis 生成projos, 需要在generatorConfig.xml中配置需要生成的table(不需要生成请注释掉)，运行task:module/other/mbGenerater

### TODO事项

- 优化log的打印

### 异常处理

- api中的业务异常抛出ServiceException、在GlobalController中统一处理
- 重复使用的错误信息、应该定义到ApiErrors中

### Swagger文档

- [Swagger文档](http://localhost:3999/swagger-ui.html)

### 返回值格式化

- 错误

```
{"success":false,"errCode":20,"errMessage":"demo的业务数据不对！"}
```

- 正确

```
{"success":false,"data":"业务数据格式"}
```