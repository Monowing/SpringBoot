# SpringBoot
SpringBoot的各种整合

[跳转到个人简介](#个人简介)

## 数据库连接
数据库为mybatis_demo

###建表，创建数据：

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
###数据库连接配置
```yaml
spring:
  #数据库连接配置
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/mybatis_demo?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC
    username: root
    password: 123456
```


##一、整合mybatis

###源代码路径com.example.demo.mybatisdemo
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

###yaml配置文件：application.yml
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

###启动application添加扫描

```java

//添加扫描
@MapperScan("com.example.demo.mybatisdemo.mapper")


```

###mapper文件路径

classpath:mapper/*.xml


##二、整合redis

###源代码路径com.example.demo.redisdemo
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

###redis配置
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

注意添加spring配置的时候，不要多spring字段出来,
例如数据库连接和redis连接都是spring起头
请不要出现
```yaml
spring:
    redis:
      ...    
spring:
    datasource:
      ...
```
等情况


##三、整合swagger

###源代码路径com.example.demo.swagger
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

# 个人简介