# java-web
一个完整的jsp+servlet+mysql流程
------
第一步：安装jdk
---
1、下载jdk1.8.0_161.tar.gz

2、新建jdk文件夹
cd /usr/local/
mkdir jdk

3、通过WinSCP将jdk文件上传到云主机jdk文件中

4、解压
Tar -zxvf jdk1.8.0_161

5、配置java环境
Vim  /etc/profile
在末尾加入
JAVA_HOME=/usr/local/jdk/jdk1.8.0_161  //jdk安装目录
PATH=$JAVA_HOME/bin:$PATH
CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export JAVA_HOME
export PATH
export CLASSPATH

6、检验是否配置成功
输入 java -version
若显示java版本，则成功



第二步：安装tomcat
---
1、下载tomcat安装包 //.tar.gz

2、新建文件夹
Cd /usr/local
Mkdir tomcat

3、通过WinSCP将压缩包上传

4、tar -zxvf解压压缩包

进入tomcat/bin文件
运行./startup.sh启动tomcat
运行./shutdown.sh关闭tomcat



第三步：安装mariadb
---
一、安装MariaDB
 yum update && yum install mariadb mariadb-server # CentOS

2、一但MariaDB软件包完成了安装，需要确保数据库服务启动运行，并且能开机自动启动
 systemctl start mariadb && systemctl enable mariadb

3、MariaDB的安全加固
完成以上操作后，是时候对MariaDB的安全进行加固了。需要运行mysql_secure_installation脚本。此脚本可以实现：
- 为数据库root用户设置或重置密码
- 禁止匿名用户登录
- 禁止root用户的远程访问，只允许本地localhost访问
- 删除test数据库（任何人都可以访问的数据库）
- 激活以上1～4选项
	
4、在CentOS系统中，还需要告诉SELinux允许MariaDB的监听端口穿透防火墙，然后重启服务。
 yum install policycoreutils-python
 semanage port -a -t mysqld_port_t -p tcp 20500
 
 
 
 第四步：配置mariadb
---
允许远程访问mariadb数据库
首先配置允许访问的用户，采用授权的方式给用户权限
1	GRANT ALL PRIVILEGES ON *.* TO 'root'@'%'IDENTIFIED BY '123456' WITH GRANT OPTION;
 说明：root是登陆数据库的用户，123456是登陆数据库的密码，*就是意味着任何来源任何主机反正就是权限很大的样子。
最后配置好权限之后不应该忘记刷新使之生效
1	flush privileges;
 再次访问就可以了吧。



第五步：配置防火墙iptable
---
1.关闭默认的firewall防火墙
systemctl stop firewalld.service #停止firewall  
systemctl disable firewalld.service #禁止firewall开机启动  
firewall-cmd --state #查看默认防火墙状态（关闭后显示notrunning，开启后显示running）  


2.开启iptables
yum install iptables （根据centOS7的版本和内核，有些版本已经装过，可以跳过此命令）  
yum install iptables-services  
service iptables restart  
chkconfig iptables on或者systemctl enable iptables.service开机自启  


3.编辑防火墙文件（开启了21,22,80,3306端口）
vim /etc/sysconfig/iptables
 
  sampleconfiguration for iptables service   
  you can edit thismanually or use system-config-firewall   
  please do not askus to add additional ports/services to this default configuration   
*filter   
:INPUT ACCEPT [0:0]   
:FORWARD ACCEPT [0:0]   
:OUTPUT ACCEPT [0:0]   
-A INPUT -m state --state RELATED,ESTABLISHED -j ACCEPT    
-A INPUT -p icmp -j ACCEPT   
-A INPUT -i lo -j ACCEPT   
-A INPUT -p tcp -m state --state NEW -m tcp --dport 21 -j ACCEPT   
-A INPUT -p tcp -m state --state NEW -m tcp --dport 22 -j ACCEPT   
-A INPUT -p tcp -m state --state NEW -m tcp --dport 80 -j ACCEPT   
-A INPUT -p tcp -m state --state NEW -m tcp --dport 3306 -j ACCEPT   
-A INPUT -j REJECT --reject-with icmp-host-prohibited   
-A FORWARD -j REJECT --reject-with icmp-host-prohibited   
COMMIT  


4.查看本机关于IPTABLES的设置情况
iptables -L -n



第六步：建立数据库
---

登录mariadb
Mysql -uroot -p
Password:

展示数据库
SHOW DATABASES;

使用数据库
USE USERS;

展示表
SHOW TABLES;

表信息
DESCRIBE <表名>;

创建表user
CREATE TABLE user(
Id int,
Name varchar(20),
Password varchar(20),
Level varchar(20),
PRIMARY KEY(id)
);

获取表信息
Select * from user;



第七步：打包war
---
将程序打包成war文件

关闭tomcat服务./shutdown.sh

war上传到/tomcat/webapps/

启动tomcat服务./startup.sh

登录ip.ip.ip.ip:8080/<war的名字>

点击注册测试一下能否连接到数据库
可以用xshell打开数据库，看看刚刚注册的用户信息是否录入



PS：如何删除上一个tomcat部署项目
---

1、删除/webapps/下的XXXX.war和xxxx项目文件

2、删除/work/catalina/localhost/XXXX项目文件

3、重新部署.war即可

1.stop tomcat服务器
2.删除webapp下的该项目
3.将work/Catalina/localhost目录下的该项目删除



PS：安装jdbc驱动模块
--

解决办法是要引入JDBC的driver。上次做的project是用的Oracle，这次自己却粗心了。
所以按照“Java Web整合开发实战”P44的方法，在Eclipse里面用JDBC连接MySQL的数据库。下载了"connector/j"的jar文件，然后在项目里新建文件夹lib，把MySQL的JDBC driver拖拽进来。
 

 
随后又在整个项目的Java Build Path里面把driver作为作为internal jar导入。

 
另外一种方法，新建lib文件夹，直接在"Java Build Path"里面添加一个External Jar也可以达到同样的效果。
