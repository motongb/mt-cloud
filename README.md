# Getting Started

基于springcloud2.2搭建的微服务脚手架。

## 第三方库

- jwt 0.9.0
- pagehelper 1.2.13
- swagger  2.9.2
- 通用mapper 2.1.5

## 模块说明

- mt-cloud-api  接口模块

- mt-cloud-center  服务模块

- mt-cloud-common 公共类包

- mt-cloud-eureka 注册中心

- mt-cloud-gateway 服务网关

## 服务说明

- 注册中心

mt-cloud-eureka 8000

- 网关

mt-cloud-gateway 8080

- 认证服务

mt-cloud-auth 8010

- 中间件服务

mt-cloud-middle 8020

## 中间件

- mysql 数据库
- seata 分布式事务
- minio 文件存储
- ELK 日志收集

## 部署

### pm2启动

```shell script
sh deploy.sh
```

### docker-compose启动

```shell script
docker-compose up -d
```

## todo

|功能|状态|
|:-------:|:------:|
|minio文件存储|已完成|
|ELK日志收集|已完成|
|分布式事务seata|已完成|
|配置中心config|已完成|
|链路跟踪zipkin|已完成|
|服务熔断、限流|已完成|
|任务调度XXL-JOB|已完成|
|多数据源读写分离|未开始|
|mysql分库分表|未开始|
|持续交付Jenkins|未开始|
