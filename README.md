# Getting Started

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

- 基础服务

mt-cloud-base 8010

- 业务服务1

mt-cloud-book 8020

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