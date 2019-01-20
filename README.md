# Lifecat SSM

![java](https://img.shields.io/badge/language-java-red.svg)
![许可](https://img.shields.io/dub/l/vibe-d.svg) 
:cat: :smiley_cat: :kissing_cat:

> Spring + SpringMVC + Mybatis + jQuery，搭建JavaWeb后台管理系统，使用shiro权限控制 + activemq消息队列 + mail邮件服务，实现了AOP日志服务 + 统一异常处理 + 自定义注解处理器等功能。

#### [线上DEMO地址](http://www.lifecat.club/ssm)

> 登录用户名:admin 登录密码:123456

## 项目部署
### 本地部署
``` bash
# Clone下载项目到本地
git clone https://github.com/kevinten10/SSM-lifecat

# 配置相关文件
进入src/main/resources包
1. jdbc.properties(必须)   :修改为自己的数据库配置
2. mail.properties(非必须) :需要先去163开启邮箱服务，才可发送邮件  
    
# 配置数据库
已导出数据库SQL文件, (建议使用navicat)lifecat.sql文件即可生成对应数据库以及DEMO数据

# 配置tomcat
(使用idea)配置tomcat的Artifact时, Application context(即项目名)需要设为"/ssm"

# 启动运行
```

### 云服务器部署--tomcat多项目部署
```bash
# 部署Javaweb开发环境
# 生成war文件
# 放到对应tomcat目录下(可以放多个war，访问时根据项目名区分)
```
云部署相关教程: [centos云服务器部署Javaweb应用](https://blog.csdn.net/wsh596823919/article/details/79717993)

## DEMO

 ![show](doc/image/show2-1.png)
 
 ![show](doc/image/show2-2.png)
 
 ![show](doc/image/show2-3.png)
  

  
