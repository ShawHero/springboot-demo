开发背景

  方便开发人员快速进行环境搭建和Web应用开发。
  

技术选型

1、	缓存：Redis

Redis是一个开源的使用ANSI C语言编写、支持网络、可基于内存亦可持久化的日志型、Key-Value数据库，并提供多种语言的API。

2、	数据库：MySQL

MySQL是一个关系型数据库管理系统，由瑞典MySQL AB 公司开发，目前属于 Oracle 旗下产品。MySQL 是最流行的关系型数据库管理系统之一

3、	数据源：Druid

Druid是阿里巴巴开源平台上的一个项目，整个项目由数据库连接池、插件框架和SQL解析器组成。该项目主要是为了扩展JDBC的一些限制，可以让程序员实现一些特殊的需求，比如向密钥服务请求凭证、统计SQL信息、SQL性能收集、SQL注入检查、SQL翻译等，程序员可以通过定制来实现自己需要的功能。

4、	日志：log4j2 

Log4j2是Apache的著名项目，是一个高性能日志框架。

5、	数据层访问：Spring data jpa

JPA是Java Persistence API的简称，中文名Java持久层API，是JDK 5.0注解或XML描述对象－关系表的映射关系，并将运行期的实体对象持久化到数据库中。Spring data jpa是在JPA规范下提供了Repository层的实现，但是使用哪一种ORM需要你来决定。

6、	简化开发：Lombok

Lombok是一个可以通过简单的注解形式来帮助我们简化消除一些必须有但显得很臃肿的Java代码的工具，通过使用对应的注解，可以在编译源码的时候生成对应的方法。

7、	json对象转换：Fastjson

Fastjson是一个Java语言编写强大的JSON处理器,由阿里巴巴大公司开发。

8、	文档：Swagger2

Swagger 是一款RESTFUL接口的文档在线自动生成与功能测试功能软件。

9、	框架：Spring Boot/Spring Cloud 

Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。通过这种方式，Spring Boot致力于在蓬勃发展的快速应用开发领域(rapid application development)成为领导者。
Spring Cloud是一系列框架的有序集合。它利用Spring Boot的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，都可以用Spring Boot的开发风格做到一键启动和部署。Spring并没有重复制造轮子，它只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组合起来，通过Spring Boot风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包。


目录结构

src

模块基准包：cn.itshaw模块名

——bean		：数据传输对象

——config：模块配置

——constant：模块常量

——controller：控制层

——domain：实体对象

——filter：过滤器

——repository：数据库访问层

——service：业务服务层

——task：定时任务

——util：模块业务工具类

——Application.java：程序入口

resources

——application.yml :主配置文件

——application-dev.yml：开发环境配置

——application-test.yml: 测试环境配置 

——application-prd.yml: 生产环境配置 

——config.properties：模块属性文件（主要是用于存放错误编码和对应的错误描述信息）


注意事项

1、	本地应用时可以修改参数spring.profiles.active（解决生产环境、测试和开发环境不同配置文件切换问题）

2、	部署应用时需要新增JVM参数（解决生产环境和测试环境不同配置文件切换问题）：  -Dspring.profiles.active=dev（开发）/test(测试) /prd(生产)

3、	支持log4j2异步日志需要新增jvm配置-DLog4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector

4、	使用lombok功能需要在eclipse或idea中按照lombok插件
