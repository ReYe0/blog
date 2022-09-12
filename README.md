# blog
从零开始的blog
# vue记录
vue采用的3.2 mavonEdit 暂不支持，换用v-md-editor

当报错：ERR! Cannot read property 'pickAlgorithm' of null
需要清楚缓存 重新下载依赖：
 
npm cache clear --force

npm install

el-menu-item 无法跳转时，在 el-menu 加入 router 就好了

# springboot
如何将vue文件和springboot 放在同一工作空间下？



创建maven项目，创建仓库，在设置中的Version Control下的directory Mapping 中 根目录

# docker 
jar 转镜像
当前目录下：docker build -f ./dockerfile -t 生成镜像的名字 .

运行镜像：① docker run -d --name 名字 -p 80:80 名字
    ② docker run -it -p 80:80 名字
文件写法：
```html
FROM openjdk: 8u191
ADD . /eureka-config-server-4. 1. 0. RELEASE. jar /app. jar
ENV server. port 6001
CMD exec java -server -Xms128m -Xmx128m -jar app. jar
```
# docker 挂载目录
docker run -d --name cms-server -v /tmp/cms4/template/export/:/tmp/cms4/template/export/ -p 6010:6010 cms-server

参考的链接：
https://blog.csdn.net/weixin_45526437/article/details/125139901
https://blog.csdn.net/elizabethxxy/article/details/110124105
http://t.zoukankan.com/jacksonxiao-p-11217295.html


# git
编写 .gitignore 文件 如果已经提交过，那么为了让它生效，需要进行如下操作

    git rm -r --cached .
    git add .
    git commit -m '.gitignore'


# gitlab 拉去远程代码合并命令
git remote -v
git remote add 匿名 链接
git fetch 匿名
git merge 匿名/分支

# 阿里云 docker  mysql
进入容器：docker exec -it mysql名字 bash
登陆：mysql -uroot -p
查看用户信息：select host,user,plugin,authentication_string from mysql.user;
新增用户：CREATE USER 'hmf'@'%' IDENTIFIED BY '123456';
查看数据库：show databases;
创建数据库：create database 名字 character set utf8;


