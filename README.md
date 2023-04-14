# java-microservice
Spring Cloud Alibaba 搭建学习

### 如何创建一个新的服务

比如我想创建一个user服务： <font color=red>microservice-user</font>

1、复制一份microservice-demo目录到根目录下，命名为 microservice-user

2、修改pom.xml文件

`	<artifactId>microservice-demo</artifactId>
 	<version>1.0.0-SNAPSHOT</version>
 	<name>Microservice :: Demo</name>
 	<description>demo project for Spring Boot cloud alibaba </description>
 `
把 **demo** 改为 **user**

3、修改/src/main/java/com/myproject/DemoServiceApplication.java 文件名为 UserServiceApplication.java
以及类名

4、修改 src/main/resources/application.yml 文件
`server:
  port: 8202
  servlet:
    context-path: /demo-service
`
端口及path

`spring:
   application:
     name: demoservice
`
修改name

`  typeAliasesPackage: com.myproject.models.demoservice.*.entity
`
修改包名

5、 修改src/main/resources/banner.txt里面的内容
 
6、修改父工程的 pom文件新增 microservice-user模块
`<modules>
     <module>microservice-test</module>
     <module>microservice-gateway</module>
     <module>microservice-demo</module>
     <module>microservice-user</module>
 </modules>

更新maven

7、修改：src/main/java/com/myproject/demoservice 和src/main/java/com/myproject/models/demoservice 目录名， 在更新maven后， 修改目录名会自动更新包名

8、修改microservice-gateway/src/main/resources/application.yml 文件， 添加 routes 
