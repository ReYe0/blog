# blog
从零开始的blog
# vue记录
vue采用的3.2 mavonEdit 暂不支持，换用v-md-editor
# springboot
如何将vue文件和springboot 放在同一工作空间下？

创建maven项目，创建仓库，在设置中的Version Control下的directory Mapping 中 根目录

# docker 
jar 转镜像
当前目录下：docker build -f ./dockerfile -t 生成镜像的名字 .

运行镜像：① docker run -d --name 名字 -p 80:80 名字
    ② docker run -it -p 80:80 名字