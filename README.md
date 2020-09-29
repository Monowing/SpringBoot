# SpringBoot
SpringBoot的各种整合


# 目录

[一、数据库连接](#数据库连接)

[二、整合mybatis](#整合mybatis)

[三、整合redis](#整合redis)

[四、整合swagger](#整合swagger)

[五、自定义注解](#自定义注解)





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


# 整合mybatis

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

## 3.启动application添加扫描

```java

//添加扫描
@MapperScan("com.example.demo.mybatisdemo.mapper")


```

##4.mapper文件路径

classpath:mapper/*.xml


# 整合redis

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



# 整合swagger

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

## 2.网页地址

查看swagger文档网址:[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)


# 整合rabbitmq
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

##2.rabbitmq配置

```yaml
spring:
  rabbitmq:
    host: 127.0.0.1
    port: 5672
    username: guest
    password: guest
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




