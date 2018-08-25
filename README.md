# lifecat-web

![java](https://img.shields.io/badge/language-java-red.svg)
![许可](https://img.shields.io/dub/l/vibe-d.svg) 
:cat: :smiley_cat: :kissing_cat:

> 这是lifecat项目的第二篇，是与项目一相对应的后台管理系统，它使用Spring+SpringMVC+Mybatis的项目架构搭建，同时引入使用了一些如消息邮件等中间件服务，有良好的注释以及代码规范适合SSM框架的学习

#### [线上DEMO地址](http://www.lifecat.club:8080/ssm)

### 后续项目线上地址 (建议由浅入深的按顺序学习)

[lifecatweb的jsp+servlet项目](http://www.lifecat.club:8080/lifecatweb)

[Vuejs+SpringBoot前后端分离重构lifecatweb(仅部署前端)](http://www.lifecat.club/lifecat)

[Vuejs+SpringBoot前后端分离重构后台管理系统(仅部署前端)](http://www.lifecat.club/admin)

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

## 项目分析

[若您已部署成功, 想深入理解整体项目的架构以及流程讲解, 点击阅读项目分析教程](Tutorial.md)

## DEMO

 ![show](Image/show2-1.png)
 
 ![show](Image/show2-2.png)
 
 ![show](Image/show2-3.png)
  
### lifecat相关项目
  [v1 jsp+servlet+mysql实现Javaweb](https://github.com/kevinten10/lifecatweb)    
  [v2 ssm框架实现Javaweb后台管理系统](https://github.com/kevinten10/SSM-lifecat)  
  [v3 前后端分离之SpringBoot实现Java后端开发](https://github.com/kevinten10/springboot-lifecat)  
  [v3 前后端分离之vue实现后台管理系统](https://github.com/kevinten10/Vue-Admin-lifecat)  
  [v3 前后端分离之vue实现仿ins效果web开发](https://github.com/kevinten10/Web-lifecat)  
  
  [ex wechat 微信移动端小程序开发](https://github.com/kevinten10/WeChat-lifecat)  
  [ex hadoop 分布式平台进行数据处理](https://github.com/kevinten10/Hadoop-lifecat)  
  [ex android 相应Android相册应用](https://github.com/kevinten10/Android-lifecat)  
  [ex python 机器学习进行图像智能处理](https://github.com/kevinten10/Python-lifecat)  
  
  