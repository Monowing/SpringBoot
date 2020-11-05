# SpringBoot
SpringBoot的各种整合


# 目录

[一、数据库连接](#数据库连接)

[二、整合MyBatis](#整合MyBatis)

[三、整合Redis](#整合Redis)

[四、整合Swagger](#整合Swagger)

[五、整合RabbitMQ](#整合RabbitMQ)

[六、自定义注解](#自定义注解)

[七、整合MongoDB](#整合MongoDB)

[七、Aop](#Aop)

# 数据库连接

[跳转目录](#目录)

数据库为mybatis_demo

## 1.建表，创建数据：

```sql
-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'laowang', '112233');
INSERT INTO `tb_user` VALUES ('2', 'laoli', '123456');
INSERT INTO `tb_user` VALUES ('3', 'clg', '123456');
INSERT INTO `tb_user` VALUES ('4', '1clg1', '123456');
INSERT INTO `tb_user` VALUES ('5', 'clg2', '123456');

```
## 2.数据库连接配置
```yaml
spring:
  #数据库连接配置
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/mybatis_demo?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC
    username: root
    password: 123456
```

pom添加maven依赖
```xml
<!--mysql数据库驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.38</version>
        </dependency>
```

# 整合MyBatis

[跳转目录](#目录)

## 1.源代码路径

com.example.demo.mybatisdemo

```java
//所有的mybatis整合的源代码所在的包
import com.example.demo.mybatisdemo.*;

// controller文件
import com.example.demo.mybatisdemo.controller.*;
// entity文件
import com.example.demo.mybatisdemo.entity.*;
// mapper文件
import com.example.demo.mybatisdemo.mapper.*;
// service文件
import com.example.demo.mybatisdemo.service.*;
// serviceimpl文件
import com.example.demo.mybatisdemo.serviceimpl.*;

```

## 2.yaml配置文件

application.yml

```yaml
#mybatis的相关配置
mybatis:
  #mapper配置文件
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: com.example.demo.mybatisdemo.entity
  #开启驼峰命名
  configuration:
    map-underscore-to-camel-case: true
```

```xml

<!--mybatis 依赖-->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.3</version>
        </dependency>
```
## 3.启动application添加扫描

```java

//添加扫描
@MapperScan("com.example.demo.mybatisdemo.mapper")


```

## 4.mapper文件路径

classpath:mapper/*.xml




# 整合Redis

[跳转目录](#目录)

## 1.源代码路径

com.example.demo.redisdemo

```java
//所有的redis整合的源代码所在的包
import com.example.demo.redisdemo.*;

// controller文件
import com.example.demo.redisdemo.controller.*;
// config文件
import com.example.demo.redisdemo.config.*;
// utils文件
import com.example.demo.redisdemo.utils.*;

```

## 2.redis配置
```yaml
spring:

  # redis配置
  redis:
    # Redis数据库索引（默认为0）
    database: 0
    # Redis服务器地址
    host: 127.0.0.1
    # Redis服务器连接端口
    port: 6379
    # Redis服务器连接密码（默认为空）
    password:
    jedis:
      pool:
        # 连接池最大连接数（使用负值表示没有限制）
        max-active: 200
        # 连接池最大阻塞等待时间（使用负值表示没有限制）
        max-wait: -1s
        # 连接池中的最大空闲连接
        max-idle: 10
        # 连接池中的最小空闲连接
        min-idle: 0
    # 连接超时时间（毫秒）
    timeout: 1000ms

```

pom添加maven依赖
```xml

<!-- redis -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
```


# 整合Swagger

[跳转目录](#目录)


## 1.源代码路径

com.example.demo.swagger

```java
//所有的redis整合的源代码所在的包
import com.example.demo.swagger.*;

// controller文件
import com.example.demo.swagger.controller.*;
// config文件
import com.example.demo.swagger.config.*;
// entity文件
import com.example.demo.swagger.entity.*;

```
## 2.配置

pom添加maven依赖
```xml
<!-- swagger 依赖-->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
        </dependency>
```

## 3.网页地址

查看swagger文档网址:[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)


# 整合RabbitMQ
[跳转目录](#目录)

## 1.源代码路径

com.example.demo.rabbitmq

```java
//所有的redis整合的源代码所在的包
import com.example.demo.rabbitmq.*;

// application文件
import com.example.demo.rabbitmq.application.*;
// controller文件
import com.example.demo.rabbitmq.controller.*;
// direct文件
import com.example.demo.rabbitmq.direct.*;
// fanout文件
import com.example.demo.rabbitmq.fanout.*;
// hello文件
import com.example.demo.rabbitmq.hello.*;
// topic文件
import com.example.demo.rabbitmq.topic.*;
// user文件
import com.example.demo.rabbitmq.user.*;

```

## 2.RabbitMQ配置

```yaml
spring:
  rabbitmq:
    host: 127.0.0.1
    port: 5672
    username: guest
    password: guest
```

pom添加maven依赖
```xml
        
        <!-- rabbitmq依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-amqp</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.amqp</groupId>
            <artifactId>spring-rabbit-test</artifactId>
            <scope>test</scope>
        </dependency>


```

# 自定义注解

[跳转目录](#目录)

路径位置：com.example.demo.other.Annotation

## 1.ClassAnnotation
自定义的类注解

## 2.FieldAnnotation
自定义的字段注解

## 3.MyAnnotation
自定义注解

## 4.MyAnnotationClass
自定义注解类

## 5.MyAnnotationMain
自定义注解main类



# 整合MongoDB

[跳转目录](#目录)

## 1.源代码路径

```java
import com.example.demo.mongodb.*;

// controller文件
import com.example.demo.mongodb.controller.*;
// dao文件
import com.example.demo.mongodb.dao.*;
// entity文件
import com.example.demo.mongodb.entity.*;

```

## 2.mongodb配置

请添加自己的mongodb的地址和表
```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/mongodb_test

```
pom添加maven依赖
```xml
    <!-- MongoDB-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>
```

# Aop

[跳转目录](#目录)

添加aop的token验证操作

## 1.源代码路径
```java
import com.example.demo.token.*;

//controller文件夹
import com.example.demo.token.controller.*;
//Annotation文件夹
import com.example.demo.token.Annotation.*;
//aspect文件夹
import com.example.demo.token.aspect.*;

```

## 2.配置

pom添加maven依赖
```xml

    <!--引入AOP依赖-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-aop</artifactId>
    </dependency>


```
