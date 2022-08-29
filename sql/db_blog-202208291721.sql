-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: 47.108.90.61    Database: db_blog
-- ------------------------------------------------------
-- Server version	5.7.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_category`
--

DROP TABLE IF EXISTS `tb_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL COMMENT '分类名',
  `pid` bigint(20) DEFAULT '-1' COMMENT '父分类id，如果没有父分类为-1',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `status` char(1) DEFAULT '0' COMMENT '状态0:正常,1禁用',
  `create_by` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_category`
--

LOCK TABLES `tb_category` WRITE;
/*!40000 ALTER TABLE `tb_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_blog_tag`
--

DROP TABLE IF EXISTS `tb_blog_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_blog_tag` (
  `article_id` bigint(20) NOT NULL COMMENT '文章 ID',
  `tag_id` bigint(20) NOT NULL COMMENT '标签 ID',
  PRIMARY KEY (`article_id`,`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章-标签表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_blog_tag`
--

LOCK TABLES `tb_blog_tag` WRITE;
/*!40000 ALTER TABLE `tb_blog_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_blog_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tag`
--

DROP TABLE IF EXISTS `tb_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL COMMENT '标签名',
  `create_by` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='标签表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tag`
--

LOCK TABLES `tb_tag` WRITE;
/*!40000 ALTER TABLE `tb_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_blog`
--

DROP TABLE IF EXISTS `tb_blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '文章标题',
  `thumbnail` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '文章首图，用于随机文章展示',
  `description` longtext CHARACTER SET utf8mb4 NOT NULL COMMENT '描述',
  `content` longtext CHARACTER SET utf8mb4 NOT NULL COMMENT '文章正文',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `views` int(11) NOT NULL COMMENT '浏览次数',
  `words` int(11) NOT NULL COMMENT '文章字数',
  `category_id` bigint(20) NOT NULL COMMENT '文章分类id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '文章作者id',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态：0,已发布；1，草稿',
  `is_top` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '是否顶置：1，是；0，不是',
  `del_flag` int(11) DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='博客实体';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_blog`
--

LOCK TABLES `tb_blog` WRITE;
/*!40000 ALTER TABLE `tb_blog` DISABLE KEYS */;
INSERT INTO `tb_blog` VALUES (1,'西游记',NULL,'hhhh','一天，孙悟空骑着白龙马去拯救了唐三藏……','2022-08-11 04:59:34','2022-08-11 04:59:34',1,12,1,NULL,NULL,'0',0),(2,'西游记',NULL,'hhhh','## ? md-editor-v3\n\nMarkdown 编辑器，vue3 版本，使用 jsx 模板 和 typescript 开发，支持切换主题、prettier 美化文本等。\n\n### ? 基本演示\n\n**加粗**，<u>下划线</u>，_斜体_，~删除线~，上标<sup>26</sup>，下标<sub>[1]</sub>，`inline code`，[超链接](https://imzbf.cc)\n\n> 引用：这是一段引用。\n\n![mark and Emoji extension](https://imzbf.github.io/md-editor-v3/imgs/mark_emoji.gif)\n\n## ? 代码演示\n\n```vue\n<template>\n  <md-editor v-model=\"text\" />\n</template>\n\n<script setup>\nimport { ref } from \'vue\';\nimport MdEditor from \'md-editor-v3\';\nimport \'md-editor-v3/lib/style.css\';\n\nconst text = ref(\'Hello Editor!\');\n</script>\n```\n\n## ? 文本演示\n\n依照普朗克长度这项单位，目前可观测的宇宙的直径估计值（直径约 930 亿光年，即 8.8 × 10<sup>26</sup> 米）即为 5.4 × 10<sup>61</sup>倍普朗克长度。而可观测宇宙体积则为 8.4 × 10<sup>184</sup>立方普朗克长度（普朗克体积）。\n\n## ? 表格演示\n\n| 昵称 | 猿龄（年） | 来自      |\n| ---- | ---------- | --------- |\n| 之间 | 4          | 中国-重庆 |\n\n## ? 公式\n\n$$\n\\sqrt[3]{x}\n$$\n\n## ☘️ 占个坑@！','2022-08-11 05:54:42','2022-08-11 05:54:42',1,12,1,NULL,NULL,'0',0),(3,'西游记',NULL,'hhhh','## ? md-editor-v3\n\nMarkdown 编辑器，vue3 版本，使用 jsx 模板 和 typescript 开发，支持切换主题、prettier 美化文本等。\n\n### ? 基本演示\n\n**加粗**，<u>下划线</u>，_斜体_，~删除线~，上标<sup>26</sup>，下标<sub>[1]</sub>，`inline code`，[超链接](https://imzbf.cc)\n\n> 引用：这是一段引用。\n\n![mark and Emoji extension](https://imzbf.github.io/md-editor-v3/imgs/mark_emoji.gif)\n\n## ? 代码演示\n\n```vue\n<template>\n  <md-editor v-model=\"text\" />\n</template>\n\n<script setup>\nimport { ref } from \'vue\';\nimport MdEditor from \'md-editor-v3\';\nimport \'md-editor-v3/lib/style.css\';\n\nconst text = ref(\'Hello Editor!\');\n</script>\n```\n\n## ? 文本演示\n\n依照普朗克长度这项单位，目前可观测的宇宙的直径估计值（直径约 930 亿光年，即 8.8 × 10<sup>26</sup> 米）即为 5.4 × 10<sup>61</sup>倍普朗克长度。而可观测宇宙体积则为 8.4 × 10<sup>184</sup>立方普朗克长度（普朗克体积）。\n\n## ? 表格演示\n\n| 昵称 | 猿龄（年） | 来自      |\n| ---- | ---------- | --------- |\n| 之间 | 4          | 中国-重庆 |\n\n## ? 公式\n\n$$\n\\sqrt[3]{x}\n$$\n\n## ☘️ 占个坑@！','2022-08-11 05:54:59','2022-08-11 05:54:59',1,12,1,NULL,NULL,'0',0),(4,'西游记',NULL,'hhhh','blogMapper.insert(blog)','2022-08-11 05:56:51','2022-08-11 05:56:51',1,12,1,NULL,NULL,'0',0),(5,'西游记',NULL,'hhhh','一天，孙悟空骑着白龙马去拯救了唐三藏…… ','2022-08-11 05:57:55','2022-08-11 05:57:55',1,12,1,NULL,NULL,'0',0),(6,'西游记',NULL,'hhhh','一天，孙悟空骑着白龙马去拯救了唐三藏…… ','2022-08-11 05:59:01','2022-08-11 05:59:01',1,12,1,NULL,NULL,'0',0),(7,'西游记',NULL,'hhhh','一天，孙悟空骑着白龙马去拯救了唐三藏…… ','2022-08-11 05:59:22','2022-08-11 05:59:22',1,12,1,NULL,NULL,'0',0),(8,'西游记',NULL,'hhhh','## ? md-editor-v3\n\nMarkdown 编辑器，vue3 版本，使用 jsx 模板 和 typescript 开发，支持切换主题、prettier 美化文本等。\n\n### ? 基本演示\n\n**加粗**，<u>下划线</u>，_斜体_，~删除线~，上标<sup>26</sup>，下标<sub>[1]</sub>，`inline code`，[超链接](https://imzbf.cc)\n\n> 引用：这是一段引用。\n\n![mark and Emoji extension](https://imzbf.github.io/md-editor-v3/imgs/mark_emoji.gif)\n\n## ? 代码演示\n\n```vue\n<template>\n  <md-editor v-model=\"text\" />\n</template>\n\n<script setup>\nimport { ref } from \'vue\';\nimport MdEditor from \'md-editor-v3\';\nimport \'md-editor-v3/lib/style.css\';\n\nconst text = ref(\'Hello Editor!\');\n</script>\n```\n\n## ? 文本演示\n\n依照普朗克长度这项单位，目前可观测的宇宙的直径估计值（直径约 930 亿光年，即 8.8 × 10<sup>26</sup> 米）即为 5.4 × 10<sup>61</sup>倍普朗克长度。而可观测宇宙体积则为 8.4 × 10<sup>184</sup>立方普朗克长度（普朗克体积）。\n\n## ? 表格演示\n\n| 昵称 | 猿龄（年） | 来自      |\n| ---- | ---------- | --------- |\n| 之间 | 4          | 中国-重庆 |\n\n## ? 公式\n\n$$\n\\sqrt[3]{x}\n$$\n\n## ☘️ 占个坑@！','2022-08-11 05:59:39','2022-08-11 05:59:39',1,12,1,NULL,NULL,'0',0),(9,'西游记',NULL,'hhhh','一天，孙悟空骑着白龙马去拯救了唐三藏……\n![](http://localhost:8090/blog/file/f601f89a13804285985dd14dbd5b4080.png)\n','2022-08-12 01:24:06','2022-08-12 01:24:06',1,12,1,NULL,NULL,'0',0),(10,'西游记',NULL,'hhhh','一天，孙悟空骑着白龙马去拯救了唐三藏…… ','2022-08-12 01:25:47','2022-08-12 01:25:47',1,12,1,NULL,NULL,'0',0),(11,'西游记','http://localhost:8090/blog/file/89a349921ea343a5a950078248f6f411.png','hhhh','一天，孙悟空骑着白龙马去拯救了唐三藏…… \n成功与否\n![](http://localhost:8090/blog/file/89a349921ea343a5a950078248f6f411.png)\n\n\n','2022-08-12 01:28:55','2022-08-12 01:28:55',1,12,1,NULL,NULL,'0',0),(12,'西游记','https://imzbf.cc','hhhh','## ? md-editor-v3\n\nMarkdown 编辑器，vue3 版本，使用 jsx 模板 和 typescript 开发，支持切换主题、prettier 美化文本等。\n\n### ? 基本演示\n\n**加粗**，<u>下划线</u>，_斜体_，~删除线~，上标<sup>26</sup>，下标<sub>[1]</sub>，`inline code`，[超链接](https://imzbf.cc)\n\n> 引用：这是一段引用。\n\n![mark and Emoji extension](https://imzbf.github.io/md-editor-v3/imgs/mark_emoji.gif)\n\n## ? 代码演示\n\n```vue\n<template>\n  <md-editor v-model=\"text\" />\n</template>\n\n<script setup>\nimport { ref } from \'vue\';\nimport MdEditor from \'md-editor-v3\';\nimport \'md-editor-v3/lib/style.css\';\n\nconst text = ref(\'Hello Editor!\');\n</script>\n```\n\n## ? 文本演示\n\n依照普朗克长度这项单位，目前可观测的宇宙的直径估计值（直径约 930 亿光年，即 8.8 × 10<sup>26</sup> 米）即为 5.4 × 10<sup>61</sup>倍普朗克长度。而可观测宇宙体积则为 8.4 × 10<sup>184</sup>立方普朗克长度（普朗克体积）。\n\n## ? 表格演示\n\n| 昵称 | 猿龄（年） | 来自      |\n| ---- | ---------- | --------- |\n| 之间 | 4          | 中国-重庆 |\n\n## ? 公式\n\n$$\n\\sqrt[3]{x}\n$$\n\n## ☘️ 占个坑@！','2022-08-25 07:07:51','2022-08-25 07:07:51',1,12,1,NULL,NULL,'0',0),(13,'西游记','https://imzbf.cc','hhhh','## ? md-editor-v3\n\nMarkdown 编辑器，vue3 版本，使用 jsx 模板 和 typescript 开发，支持切换主题、prettier 美化文本等。\n\n### ? 基本演示\n\n**加粗**，<u>下划线</u>，_斜体_，~删除线~，上标<sup>26</sup>，下标<sub>[1]</sub>，`inline code`，[超链接](https://imzbf.cc)\n\n> 引用：这是一段引用。\n\n![mark and Emoji extension](https://imzbf.github.io/md-editor-v3/imgs/mark_emoji.gif)\n\n## ? 代码演示\n\n```vue\n<template>\n  <md-editor v-model=\"text\" />\n</template>\n\n<script setup>\nimport { ref } from \'vue\';\nimport MdEditor from \'md-editor-v3\';\nimport \'md-editor-v3/lib/style.css\';\n\nconst text = ref(\'Hello Editor!\');\n</script>\n```\n\n## ? 文本演示\n\n依照普朗克长度这项单位，目前可观测的宇宙的直径估计值（直径约 930 亿光年，即 8.8 × 10<sup>26</sup> 米）即为 5.4 × 10<sup>61</sup>倍普朗克长度。而可观测宇宙体积则为 8.4 × 10<sup>184</sup>立方普朗克长度（普朗克体积）。\n\n## ? 表格演示\n\n| 昵称 | 猿龄（年） | 来自      |\n| ---- | ---------- | --------- |\n| 之间 | 4          | 中国-重庆 |\n\n## ? 公式\n\n$$\n\\sqrt[3]{x}\n$$\n\n## ☘️ 占个坑@！','2022-08-25 07:07:51','2022-08-25 07:07:51',1,12,1,NULL,NULL,'0',0);
/*!40000 ALTER TABLE `tb_blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_files`
--

DROP TABLE IF EXISTS `tb_files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `type` varchar(255) DEFAULT NULL COMMENT '文件类型',
  `size` double DEFAULT NULL COMMENT '文件大小kb',
  `url` varchar(255) DEFAULT NULL COMMENT '下载链接',
  `md5` varchar(255) DEFAULT NULL COMMENT '文件md5',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '是否删除，0未删除',
  `enable` tinyint(1) DEFAULT '1' COMMENT '是否应用，1，应用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_files`
--

LOCK TABLES `tb_files` WRITE;
/*!40000 ALTER TABLE `tb_files` DISABLE KEYS */;
INSERT INTO `tb_files` VALUES (1,'1',NULL,NULL,NULL,'1',NULL,NULL),(2,'AY4DBY~NJOV]3H$N}(L{(P8.png','png',40,'http://localhost:8001/file/73a6ec7eacf44da5a8733b56249ce6da.png','2ae7729449aab7c3da72e0e79d15610e',0,1),(3,'AY4DBY~NJOV]3H$N}(L{(P8.png','png',40,'http://localhost:8090/file/ce94d9b8eb534747b84b191f768d3f74.png','2ae7729449aab7c3da72e0e79d15610e',0,1),(4,'AY4DBY~NJOV]3H$N}(L{(P8.png','png',40,'http://47.108.90.61:8090/file/4a9125755c674cc8afc14e686163768c.png','2ae7729449aab7c3da72e0e79d15610e',0,1),(5,'AY4DBY~NJOV]3H$N}(L{(P8.png','png',40,'http://47.108.90.61:8090/file/170bc0d86473453ebe5171508919e62d.png','2ae7729449aab7c3da72e0e79d15610e',0,1),(6,'AY4DBY~NJOV]3H$N}(L{(P8.png','png',40,'http://47.108.90.61:8090/blog/file/44f8968923834171883ae5f320db6f76.png','2ae7729449aab7c3da72e0e79d15610e',0,1),(7,'AY4DBY~NJOV]3H$N}(L{(P8.png','png',40,'http://localhost:8090/blog/file/0616cf41bcdc4d3ba0a9b772e2e64f33.png','2ae7729449aab7c3da72e0e79d15610e',0,1),(8,'CZ2QQO@P(6U~BSA`TH`VMYJ.png','png',357,'http://localhost:8090/blog/file/f601f89a13804285985dd14dbd5b4080.png','aa9009fb14e4b92176c06e219c364ea6',0,1),(9,'CZ2QQO@P(6U~BSA`TH`VMYJ.png','png',357,'http://localhost:8090/blog/file/f6c78d24dc3f46089b0173c4e9ec267e.png','aa9009fb14e4b92176c06e219c364ea6',0,1),(10,'CZ2QQO@P(6U~BSA`TH`VMYJ.png','png',357,'http://localhost:8090/blog/file/bc2708f4e06845b28b818a6c273df7ea.png','aa9009fb14e4b92176c06e219c364ea6',0,1),(11,'CZ2QQO@P(6U~BSA`TH`VMYJ.png','png',357,'http://localhost:8090/blog/file/89a349921ea343a5a950078248f6f411.png','aa9009fb14e4b92176c06e219c364ea6',0,1);
/*!40000 ALTER TABLE `tb_files` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-29 17:21:28
