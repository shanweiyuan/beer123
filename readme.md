# 使用指南

## 信息管理系统

### 功能介绍：

#### 1.QQ邮箱验证注册

#### 2.信息增删改查

#### 3.页面防拦截



## 上手指南

### 为了在运行过程中避免一些意想不到的错误，所以建议你准备好

### 1.谷歌浏览器 或者 Edge

### 2.JDK 11+ 

### 3.idea2021

### 4.配置MAVEN 3.0+ 并部署 阿里云镜像

### 5.MySQL 5.5



## 技术栈

### 1.Bootstrap 4 - 前端页面

### 2.SpringBoot -后端

### 3.thymeleaf - 模板引擎

### 4.MySQL - 数据库

### 5.Mybatis - 持久层框架



## 上手准备

#### 1.创建一个数据库

```sql
create DATABASE email;
```

#### 2.在数据库中创建user表
```sql
CREATE TABLE `user` (
                        `id` int(20) NOT NULL AUTO_INCREMENT,
                        `username` varchar(255) NOT NULL,
                        `password` varchar(255) NOT NULL,
                        `email` varchar(255) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

insert into user (username,password,email) values ('admin',123456,'admin@demo.com');
```

#### 3.等待MAVEN 将所有依赖下载完毕

#### 4.运行 打开 

```url
http://localhost:8085
```



## 使用步骤

### 1.点击右上角登录

2.




# 附页

## Tips

### 一，安装idea

 1.在浏览器输入以下网址进入官网直接下载

```url
https://www.jetbrains.com/idea/download/#section=windows
```

#### 下载完成后无脑点击下一步即可

### 二，idea配置service启动（springboot多服务启动）

#### 1.打开idea，在左侧项目展示栏中找到.idea，双击打开.idea
#### 2.在.idea下双击打开workspace.xml

#### 3.编辑workspace.xml文件，在结尾添加如下配置代码

```xml
<component name="RunDashboard">
  <option name="configurationTypes">
    <set>
      <option value="SpringBootApplicationConfigurationType" />
    </set>
  </option>
</component>
```
#### 4.重启idea即可



### 三，在MAVEN 配置 阿里云镜像

#### 如果没有安装过maven，是用的idea自带的maven，那就是idea的安装目录下 `/plugins/maven/lib/maven3`这个目录。

#### 然后在conf下打开settings.xml，加入如下代码：

```xml
<mirrors>
	<mirror>
		<id>aliyunmaven</id>
		<mirrorOf>*</mirrorOf>
		<name>阿里云公共仓库</name>
		<url>https://maven.aliyun.com/repository/public</url>
	</mirror>
  </mirrors>
```

