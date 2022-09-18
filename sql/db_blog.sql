/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : db_blog

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 18/09/2022 21:53:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_blog
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog`;
CREATE TABLE `tb_blog`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章标题',
  `thumbnail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章首图，用于随机文章展示',
  `summary` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '描述',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章正文',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `view_count` int(11) NOT NULL DEFAULT 0 COMMENT '浏览次数',
  `words` int(11) NOT NULL COMMENT '文章字数',
  `category_id` bigint(20) NOT NULL COMMENT '文章分类id',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '文章作者id',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '状态：0,已发布；1，草稿',
  `is_top` tinyint(1) NULL DEFAULT 0 COMMENT '是否顶置：1，是；0，不是',
  `del_flag` int(11) NULL DEFAULT 0 COMMENT '删除标志（0代表未删除，1代表已删除）',
  `blog_type_id` tinyint(20) NULL DEFAULT NULL COMMENT '博客类型id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '博客实体' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_blog
-- ----------------------------
INSERT INTO `tb_blog` VALUES (15, 'test', 'https://i.niupic.com/images/2022/03/11/9Wl7.jpg', 'markdown测试', '# 字符效果\n\n* ~~删除线~~ <s>删除线（开启识别HTML标签时）</s>\n\n* *斜体字* _斜体字_\n* **粗体** __粗体__\n* ***粗斜体*** ___粗斜体___\n\n* 上标：X<sub>2</sub>，下标：O<sup>2</sup>\n\n* ==高亮==\n\n* `Inline Code`\n\n> 引用：如果想要插入空白换行（即 `<br>` 标签），在插入处先键入两个以上的空格然后回车即可\n\n# 图像\n下面是一张我家硝子的壁纸?:\n![硝子1](https://i.niupic.com/images/2022/03/11/9Wl7.jpg)\n再来一张好了?：\n![硝子2](https://i.niupic.com/images/2022/03/12/9Wme.jpg)\n\n#  超链接\n* [普通链接](https://www.cnblogs.com/zhiyiYo/)\n* [*斜体链接*](https://www.cnblogs.com/zhiyiYo/)\n* [**粗体链接**](https://www.cnblogs.com/zhiyiYo/)\n\n# 脚注\n这是一个简单的脚注 [^1] 而这是一个更长的脚注 [^bignote].\n\n[^1]: 这是第一个脚注.\n\n[^bignote]: 这是一个非常长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长的脚注.\n\n\n\n# 代码\n\n## 行内代码\n在 VS Code 中按下 <kbd>Alt</kbd> + <kbd>T</kbd> + <kbd>R</kbd> 执行命令：`npm install marked`\n\n## 代码片\n\n### Python 代码\n```python\nclass Animal:\n    \"\"\" 动物类 \"\"\"\n\n    def __init__(self, age: int, name: str):\n        self.age = age\n        self.name = name\n\n    def getInfo(self) -> str:\n        \"\"\" 返回信息 \"\"\"\n        return f\'age: {self.age}; name: {self.name}\'\n\n\nclass Dog(Animal):\n    \"\"\" 狗狗类 \"\"\"\n\n    def __init__(self, age: int, name: str, gender=\'female\', color=\'white\'):\n        super().__init__(age, name)\n        self.gender = gender\n        self.__color = color\n\n    def bark(self):\n        \"\"\" 狗叫 \"\"\"\n        print(\'lololo\')\n\n    @property\n    def color(self):\n        return self.__color\n\n    @color.setter\n    def color(self, color: str):\n        if color not in [\'red\', \'white\', \'black\']:\n            raise ValueError(\'颜色不符合要求\')\n        self.__color = color\n\n\nif __name__ == \'__main__\':\n    dog = Dog(16, \'啸天\', gender=\'male\')\n    # 狗叫\n    dog.bark()\n    # 设置狗狗毛色\n    dog.color = \'blue\'\n```\n\n### HTML 代码\n\n```html\n<!DOCTYPE html>\n<html>\n    <head>\n        <mate charest=\"utf-8\" />\n        <title>Hello world!</title>\n    </head>\n    <body>\n        <h1>Hello world!</h1>\n    </body>\n</html>\n```\n\n\n\n# 列表\n\n## 无序列表\n\n* 福建\n  * 厦门\n  * 福州\n* 浙江\n* 江苏\n## 有序列表\n\n1. 动物\n   1. 人类\n   2. 犬类\n2. 植物\n3. 微生物\n\n## 任务列表\n\n- [x] 预习计算机网络\n- [ ] 复习现代控制理论\n- [ ] 刷现代控制理论历年卷\n    - [ ] 2019 年期末试卷\n    - [ ] 2020 年期末试卷\n\n\n\n# 表格\n\n| 项目   |  价格 | 数量  |\n| ------ | ----: | :---: |\n| 计算机 | $1600 |   5   |\n| 手机   |   $12 |  12   |\n| 管线   |    $1 |  234  |\n\n----\n\n# 特殊符号\n\n&copy; &  &uml; &trade; &iexcl; &pound;\n&amp; &lt; &gt; &yen; &euro; &reg; &plusmn; &para; &sect; &brvbar; &macr; &laquo; &middot;\n\nX&sup2; Y&sup3; &frac34; &frac14;  &times;  &divide;   &raquo;\n\n18&ordm;C  &quot;  &apos;\n\n# Emoji表情 :satisfied:\n* 马：:horse:\n* 星星：:star2:\n* 笑脸：:smile:\n* 跑步：:running:\n\n# 数学公式\n\n行间公式：\n$$\\sin(\\alpha)^{\\theta}=\\sum_{i=0}^{n}(x^i + \\cos(f))$$\n行内公式 $E=mc^2$\n\n# 绘图\n## 时序图\n\n```mermaid\nsequenceDiagram\n\n  Alice->>John: Hello John, how are you?\n  loop Healthcheck\n      John->>John: Fight against hypochondria\n  end\n  Note right of John: Rational thoughts!\n       John-->>Alice: Great!\n       John->>Bob   : How about you?\n       Bob-->>John  : Jolly good!\n```\n\n\n## 状态图\n\n```mermaid\nstateDiagram\n\n    [*]-->Active\n    state Active {\n        [*]-->NumLockOff\n        NumLockOff-->NumLockOn : EvNumLockPressed\n        NumLockOn-->NumLockOff : EvNumLockPressed\n        --\n        [*]-->CapsLockOff\n        CapsLockOff-->CapsLockOn : EvCapsLockPressed\n        CapsLockOn-->CapsLockOff : EvCapsLockPressed\n        --\n        [*]-->ScrollLockOff\n        ScrollLockOff-->ScrollLockOn : EvCapsLockPressed\n        ScrollLockOn-->ScrollLockOff : EvCapsLockPressed\n            }\n```', '2022-09-18 17:32:57', '2022-09-18 17:32:57', 0, 3376, 1, NULL, 1, 0, 0, 1);
INSERT INTO `tb_blog` VALUES (14, '测试Markdown', 'https://i.niupic.com/images/2022/03/11/9Wl7.jpg', '测试Markdown', '# 字符效果\n\n* ~~删除线~~ <s>删除线（开启识别HTML标签时）</s>\n\n* *斜体字* _斜体字_\n* **粗体** __粗体__\n* ***粗斜体*** ___粗斜体___\n\n* 上标：X<sub>2</sub>，下标：O<sup>2</sup>\n\n* ==高亮==\n\n* `Inline Code`\n\n> 引用：如果想要插入空白换行（即 `<br>` 标签），在插入处先键入两个以上的空格然后回车即可\n# 图像\n下面是一张我家硝子的壁纸?:\n![硝子1](https://i.niupic.com/images/2022/03/11/9Wl7.jpg)\n再来一张好了?：\n![硝子2](https://i.niupic.com/images/2022/03/12/9Wme.jpg)\n\n#  超链接\n* [普通链接](https://www.cnblogs.com/zhiyiYo/)\n* [*斜体链接*](https://www.cnblogs.com/zhiyiYo/)\n* [**粗体链接**](https://www.cnblogs.com/zhiyiYo/)\n\n# 脚注\n这是一个简单的脚注 [^1] 而这是一个更长的脚注 [^bignote].\n\n[^1]: 这是第一个脚注.\n\n[^bignote]: 这是一个非常长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长的脚注.\n\n\n\n# 代码\n\n## 行内代码\n在 VS Code 中按下 <kbd>Alt</kbd> + <kbd>T</kbd> + <kbd>R</kbd> 执行命令：`npm install marked`\n\n## 代码片\n\n### Python 代码\n```python\nclass Animal:\n    \"\"\" 动物类 \"\"\"\n\n    def __init__(self, age: int, name: str):\n        self.age = age\n        self.name = name\n\n    def getInfo(self) -> str:\n        \"\"\" 返回信息 \"\"\"\n        return f\'age: {self.age}; name: {self.name}\'\n\n\nclass Dog(Animal):\n    \"\"\" 狗狗类 \"\"\"\n\n    def __init__(self, age: int, name: str, gender=\'female\', color=\'white\'):\n        super().__init__(age, name)\n        self.gender = gender\n        self.__color = color\n\n    def bark(self):\n        \"\"\" 狗叫 \"\"\"\n        print(\'lololo\')\n\n    @property\n    def color(self):\n        return self.__color\n\n    @color.setter\n    def color(self, color: str):\n        if color not in [\'red\', \'white\', \'black\']:\n            raise ValueError(\'颜色不符合要求\')\n        self.__color = color\n\n\nif __name__ == \'__main__\':\n    dog = Dog(16, \'啸天\', gender=\'male\')\n    # 狗叫\n    dog.bark()\n    # 设置狗狗毛色\n    dog.color = \'blue\'\n```\n\n### HTML 代码\n\n```html\n<!DOCTYPE html>\n<html>\n    <head>\n        <mate charest=\"utf-8\" />\n        <title>Hello world!</title>\n    </head>\n    <body>\n        <h1>Hello world!</h1>\n    </body>\n</html>\n```\n\n\n\n# 列表\n\n## 无序列表\n\n* 福建\n  * 厦门\n  * 福州\n* 浙江\n* 江苏\n## 有序列表\n\n1. 动物\n   1. 人类\n   2. 犬类\n2. 植物\n3. 微生物\n\n## 任务列表\n\n- [x] 预习计算机网络\n- [ ] 复习现代控制理论\n- [ ] 刷现代控制理论历年卷\n    - [ ] 2019 年期末试卷\n    - [ ] 2020 年期末试卷\n\n\n\n# 表格\n\n| 项目   |  价格 | 数量  |\n| ------ | ----: | :---: |\n| 计算机 | $1600 |   5   |\n| 手机   |   $12 |  12   |\n| 管线   |    $1 |  234  |\n\n----\n\n# 特殊符号\n\n&copy; &  &uml; &trade; &iexcl; &pound;\n&amp; &lt; &gt; &yen; &euro; &reg; &plusmn; &para; &sect; &brvbar; &macr; &laquo; &middot;\n\nX&sup2; Y&sup3; &frac34; &frac14;  &times;  &divide;   &raquo;\n\n18&ordm;C  &quot;  &apos;\n\n# Emoji表情 :satisfied:\n* 马：:horse:\n* 星星：:star2:\n* 笑脸：:smile:\n* 跑步：:running:\n\n# 数学公式\n\n行间公式：\n$$\\sin(\\alpha)^{\\theta}=\\sum_{i=0}^{n}(x^i + \\cos(f))$$\n行内公式 $E=mc^2$\n\n# 绘图\n## 时序图\n\n```mermaid\nsequenceDiagram\n\n  Alice->>John: Hello John, how are you?\n  loop Healthcheck\n      John->>John: Fight against hypochondria\n  end\n  Note right of John: Rational thoughts!\n       John-->>Alice: Great!\n       John->>Bob   : How about you?\n       Bob-->>John  : Jolly good!\n```\n\n\n## 状态图\n\n```mermaid\nstateDiagram\n\n    [*]-->Active\n    state Active {\n        [*]-->NumLockOff\n        NumLockOff-->NumLockOn : EvNumLockPressed\n        NumLockOn-->NumLockOff : EvNumLockPressed\n        --\n        [*]-->CapsLockOff\n        CapsLockOff-->CapsLockOn : EvCapsLockPressed\n        CapsLockOn-->CapsLockOff : EvCapsLockPressed\n        --\n        [*]-->ScrollLockOff\n        ScrollLockOff-->ScrollLockOn : EvCapsLockPressed\n        ScrollLockOn-->ScrollLockOff : EvCapsLockPressed\n            }\n```', '2022-09-18 17:31:56', '2022-09-18 17:31:56', 0, 3375, 2, NULL, 1, 1, 0, 1);
INSERT INTO `tb_blog` VALUES (16, '特色图', 'https://i.niupic.com/images/2022/03/11/9Wl7.jpg', '水电费', '# 字符效果\n\n* ~~删除线~~ <s>删除线（开启识别HTML标签时）</s>\n\n* *斜体字* _斜体字_\n* **粗体** __粗体__\n* ***粗斜体*** ___粗斜体___\n\n* 上标：X<sub>2</sub>，下标：O<sup>2</sup>\n\n* ==高亮==\n\n* `Inline Code`\n\n> 引用：如果想要插入空白换行（即 `<br>` 标签），在插入处先键入两个以上的空格然后回车即可\n\n\n# 脚注\n这是一个简单的脚注 [^1] 而这是一个更长的脚注 [^bignote].\n\n[^1]: 这是第一个脚注.\n\n[^bignote]: 这是一个非常长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长的脚注.\n\n\n# 图像\n下面是一张我家硝子的壁纸?:\n![硝子1](https://i.niupic.com/images/2022/03/11/9Wl7.jpg)\n再来一张好了?：\n![硝子2](https://i.niupic.com/images/2022/03/12/9Wme.jpg)\n\n# 代码\n\n## 行内代码\n在 VS Code 中按下 <kbd>Alt</kbd> + <kbd>T</kbd> + <kbd>R</kbd> 执行命令：`npm install marked`\n\n## 代码片\n\n### Python 代码\n```python\nclass Animal:\n    \"\"\" 动物类 \"\"\"\n\n    def __init__(self, age: int, name: str):\n        self.age = age\n        self.name = name\n\n    def getInfo(self) -> str:\n        \"\"\" 返回信息 \"\"\"\n        return f\'age: {self.age}; name: {self.name}\'\n\n\nclass Dog(Animal):\n    \"\"\" 狗狗类 \"\"\"\n\n    def __init__(self, age: int, name: str, gender=\'female\', color=\'white\'):\n        super().__init__(age, name)\n        self.gender = gender\n        self.__color = color\n\n    def bark(self):\n        \"\"\" 狗叫 \"\"\"\n        print(\'lololo\')\n\n    @property\n    def color(self):\n        return self.__color\n\n    @color.setter\n    def color(self, color: str):\n        if color not in [\'red\', \'white\', \'black\']:\n            raise ValueError(\'颜色不符合要求\')\n        self.__color = color\n\n\nif __name__ == \'__main__\':\n    dog = Dog(16, \'啸天\', gender=\'male\')\n    # 狗叫\n    dog.bark()\n    # 设置狗狗毛色\n    dog.color = \'blue\'\n```\n\n### HTML 代码\n\n```html\n<!DOCTYPE html>\n<html>\n    <head>\n        <mate charest=\"utf-8\" />\n        <title>Hello world!</title>\n    </head>\n    <body>\n        <h1>Hello world!</h1>\n    </body>\n</html>\n```\n\n\n\n# 列表\n\n## 无序列表\n\n* 福建\n  * 厦门\n  * 福州\n* 浙江\n* 江苏\n## 有序列表\n\n1. 动物\n   1. 人类\n   2. 犬类\n2. 植物\n3. 微生物\n\n## 任务列表\n\n- [x] 预习计算机网络\n- [ ] 复习现代控制理论\n- [ ] 刷现代控制理论历年卷\n    - [ ] 2019 年期末试卷\n    - [ ] 2020 年期末试卷\n\n\n\n# 表格\n\n| 项目   |  价格 | 数量  |\n| ------ | ----: | :---: |\n| 计算机 | $1600 |   5   |\n| 手机   |   $12 |  12   |\n| 管线   |    $1 |  234  |\n\n----\n\n# 特殊符号\n\n&copy; &  &uml; &trade; &iexcl; &pound;\n&amp; &lt; &gt; &yen; &euro; &reg; &plusmn; &para; &sect; &brvbar; &macr; &laquo; &middot;\n\nX&sup2; Y&sup3; &frac34; &frac14;  &times;  &divide;   &raquo;\n\n18&ordm;C  &quot;  &apos;\n\n# Emoji表情 :satisfied:\n* 马：:horse:\n* 星星：:star2:\n* 笑脸：:smile:\n* 跑步：:running:\n\n# 数学公式\n\n行间公式：\n$$\\sin(\\alpha)^{\\theta}=\\sum_{i=0}^{n}(x^i + \\cos(f))$$\n行内公式 $E=mc^2$\n\n# 绘图\n## 时序图\n\n```mermaid\nsequenceDiagram\n\n  Alice->>John: Hello John, how are you?\n  loop Healthcheck\n      John->>John: Fight against hypochondria\n  end\n  Note right of John: Rational thoughts!\n       John-->>Alice: Great!\n       John->>Bob   : How about you?\n       Bob-->>John  : Jolly good!\n```\n\n\n## 状态图\n\n```mermaid\nstateDiagram\n\n    [*]-->Active\n    state Active {\n        [*]-->NumLockOff\n        NumLockOff-->NumLockOn : EvNumLockPressed\n        NumLockOn-->NumLockOff : EvNumLockPressed\n        --\n        [*]-->CapsLockOff\n        CapsLockOff-->CapsLockOn : EvCapsLockPressed\n        CapsLockOn-->CapsLockOff : EvCapsLockPressed\n        --\n        [*]-->ScrollLockOff\n        ScrollLockOff-->ScrollLockOn : EvCapsLockPressed\n        ScrollLockOn-->ScrollLockOff : EvCapsLockPressed\n            }\n```', '2021-02-01 17:43:39', '2022-09-18 17:43:39', 0, 3233, 1, NULL, 1, 0, 0, 2);
INSERT INTO `tb_blog` VALUES (17, '1234', 'https://i.niupic.com/images/2022/03/12/9Wme.jpg', '1234', '# 字符效果\n\n* ~~删除线~~ <s>删除线（开启识别HTML标签时）</s>\n\n* *斜体字* _斜体字_\n* **粗体** __粗体__\n* ***粗斜体*** ___粗斜体___\n\n* 上标：X<sub>2</sub>，下标：O<sup>2</sup>\n\n* ==高亮==\n\n* `Inline Code`\n\n> 引用：如果想要插入空白换行（即 `<br>` 标签），在插入处先键入两个以上的空格然后回车即可\n\n\n#  超链接\n* [普通链接](https://i.niupic.com/images/2022/03/12/9Wme.jpg)\n* [*斜体链接*](https://www.cnblogs.com/zhiyiYo/)\n* [**粗体链接**](https://www.cnblogs.com/zhiyiYo/)\n\n# 脚注\n这是一个简单的脚注 [^1] 而这是一个更长的脚注 [^bignote].\n\n[^1]: 这是第一个脚注.\n\n[^bignote]: 这是一个非常长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长的脚注.\n\n\n# 图像\n下面是一张我家硝子的壁纸?:\n![硝子1](https://i.niupic.com/images/2022/03/11/9Wl7.jpg)\n再来一张好了?：\n![硝子2](https://i.niupic.com/images/2022/03/12/9Wme.jpg)\n\n# 代码\n\n## 行内代码\n在 VS Code 中按下 <kbd>Alt</kbd> + <kbd>T</kbd> + <kbd>R</kbd> 执行命令：`npm install marked`\n\n## 代码片\n\n### Python 代码\n```python\nclass Animal:\n    \"\"\" 动物类 \"\"\"\n\n    def __init__(self, age: int, name: str):\n        self.age = age\n        self.name = name\n\n    def getInfo(self) -> str:\n        \"\"\" 返回信息 \"\"\"\n        return f\'age: {self.age}; name: {self.name}\'\n\n\nclass Dog(Animal):\n    \"\"\" 狗狗类 \"\"\"\n\n    def __init__(self, age: int, name: str, gender=\'female\', color=\'white\'):\n        super().__init__(age, name)\n        self.gender = gender\n        self.__color = color\n\n    def bark(self):\n        \"\"\" 狗叫 \"\"\"\n        print(\'lololo\')\n\n    @property\n    def color(self):\n        return self.__color\n\n    @color.setter\n    def color(self, color: str):\n        if color not in [\'red\', \'white\', \'black\']:\n            raise ValueError(\'颜色不符合要求\')\n        self.__color = color\n\n\nif __name__ == \'__main__\':\n    dog = Dog(16, \'啸天\', gender=\'male\')\n    # 狗叫\n    dog.bark()\n    # 设置狗狗毛色\n    dog.color = \'blue\'\n```\n\n### HTML 代码\n\n```html\n<!DOCTYPE html>\n<html>\n    <head>\n        <mate charest=\"utf-8\" />\n        <title>Hello world!</title>\n    </head>\n    <body>\n        <h1>Hello world!</h1>\n    </body>\n</html>\n```\n\n\n\n# 列表\n\n## 无序列表\n\n* 福建\n  * 厦门\n  * 福州\n* 浙江\n* 江苏\n## 有序列表\n\n1. 动物\n   1. 人类\n   2. 犬类\n2. 植物\n3. 微生物\n\n## 任务列表\n\n- [x] 预习计算机网络\n- [ ] 复习现代控制理论\n- [ ] 刷现代控制理论历年卷\n    - [ ] 2019 年期末试卷\n    - [ ] 2020 年期末试卷\n\n\n\n# 表格\n\n| 项目   |  价格 | 数量  |\n| ------ | ----: | :---: |\n| 计算机 | $1600 |   5   |\n| 手机   |   $12 |  12   |\n| 管线   |    $1 |  234  |\n\n----\n\n# 特殊符号\n\n&copy; &  &uml; &trade; &iexcl; &pound;\n&amp; &lt; &gt; &yen; &euro; &reg; &plusmn; &para; &sect; &brvbar; &macr; &laquo; &middot;\n\nX&sup2; Y&sup3; &frac34; &frac14;  &times;  &divide;   &raquo;\n\n18&ordm;C  &quot;  &apos;\n\n# Emoji表情 :satisfied:\n* 马：:horse:\n* 星星：:star2:\n* 笑脸：:smile:\n* 跑步：:running:\n\n# 数学公式\n\n行间公式：\n$$\\sin(\\alpha)^{\\theta}=\\sum_{i=0}^{n}(x^i + \\cos(f))$$\n行内公式 $E=mc^2$\n\n# 绘图\n## 时序图\n\n```mermaid\nsequenceDiagram\n\n  Alice->>John: Hello John, how are you?\n  loop Healthcheck\n      John->>John: Fight against hypochondria\n  end\n  Note right of John: Rational thoughts!\n       John-->>Alice: Great!\n       John->>Bob   : How about you?\n       Bob-->>John  : Jolly good!\n```\n\n\n## 状态图\n\n```mermaid\nstateDiagram\n\n    [*]-->Active\n    state Active {\n        [*]-->NumLockOff\n        NumLockOff-->NumLockOn : EvNumLockPressed\n        NumLockOn-->NumLockOff : EvNumLockPressed\n        --\n        [*]-->CapsLockOff\n        CapsLockOff-->CapsLockOn : EvCapsLockPressed\n        CapsLockOn-->CapsLockOff : EvCapsLockPressed\n        --\n        [*]-->ScrollLockOff\n        ScrollLockOff-->ScrollLockOn : EvCapsLockPressed\n        ScrollLockOn-->ScrollLockOff : EvCapsLockPressed\n            }\n```', '2022-09-18 20:52:49', '2022-09-18 20:52:49', 0, 3391, 1, NULL, 1, 0, 0, 2);
INSERT INTO `tb_blog` VALUES (18, '123', 'https://i.niupic.com/images/2022/03/12/9Wme.jpg', '123', '# 字符效果\n\n* ~~删除线~~ <s>删除线（开启识别HTML标签时）</s>\n\n* *斜体字* _斜体字_\n* **粗体** __粗体__\n* ***粗斜体*** ___粗斜体___\n\n* 上标：X<sub>2</sub>，下标：O<sup>2</sup>\n\n* ==高亮==\n\n* `Inline Code`\n\n> 引用：如果想要插入空白换行（即 `<br>` 标签），在插入处先键入两个以上的空格然后回车即可\n\n\n#  超链接\n* [普通链接](https://i.niupic.com/images/2022/03/12/9Wme.jpg)\n* [*斜体链接*](https://www.cnblogs.com/zhiyiYo/)\n* [**粗体链接**](https://www.cnblogs.com/zhiyiYo/)\n\n# 脚注\n这是一个简单的脚注 [^1] 而这是一个更长的脚注 [^bignote].\n\n[^1]: 这是第一个脚注.\n\n[^bignote]: 这是一个非常长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长的脚注.\n\n\n# 图像\n下面是一张我家硝子的壁纸?:\n![硝子1](https://i.niupic.com/images/2022/03/11/9Wl7.jpg)\n再来一张好了?：\n![硝子2](https://i.niupic.com/images/2022/03/12/9Wme.jpg)\n\n# 代码\n\n## 行内代码\n在 VS Code 中按下 <kbd>Alt</kbd> + <kbd>T</kbd> + <kbd>R</kbd> 执行命令：`npm install marked`\n\n## 代码片\n\n### Python 代码\n```python\nclass Animal:\n    \"\"\" 动物类 \"\"\"\n\n    def __init__(self, age: int, name: str):\n        self.age = age\n        self.name = name\n\n    def getInfo(self) -> str:\n        \"\"\" 返回信息 \"\"\"\n        return f\'age: {self.age}; name: {self.name}\'\n\n\nclass Dog(Animal):\n    \"\"\" 狗狗类 \"\"\"\n\n    def __init__(self, age: int, name: str, gender=\'female\', color=\'white\'):\n        super().__init__(age, name)\n        self.gender = gender\n        self.__color = color\n\n    def bark(self):\n        \"\"\" 狗叫 \"\"\"\n        print(\'lololo\')\n\n    @property\n    def color(self):\n        return self.__color\n\n    @color.setter\n    def color(self, color: str):\n        if color not in [\'red\', \'white\', \'black\']:\n            raise ValueError(\'颜色不符合要求\')\n        self.__color = color\n\n\nif __name__ == \'__main__\':\n    dog = Dog(16, \'啸天\', gender=\'male\')\n    # 狗叫\n    dog.bark()\n    # 设置狗狗毛色\n    dog.color = \'blue\'\n```\n\n### HTML 代码\n\n```html\n<!DOCTYPE html>\n<html>\n    <head>\n        <mate charest=\"utf-8\" />\n        <title>Hello world!</title>\n    </head>\n    <body>\n        <h1>Hello world!</h1>\n    </body>\n</html>\n```\n\n\n\n# 列表\n\n## 无序列表\n\n* 福建\n  * 厦门\n  * 福州\n* 浙江\n* 江苏\n## 有序列表\n\n1. 动物\n   1. 人类\n   2. 犬类\n2. 植物\n3. 微生物\n\n## 任务列表\n\n- [x] 预习计算机网络\n- [ ] 复习现代控制理论\n- [ ] 刷现代控制理论历年卷\n    - [ ] 2019 年期末试卷\n    - [ ] 2020 年期末试卷\n\n\n\n# 表格\n\n| 项目   |  价格 | 数量  |\n| ------ | ----: | :---: |\n| 计算机 | $1600 |   5   |\n| 手机   |   $12 |  12   |\n| 管线   |    $1 |  234  |\n\n----\n\n# 特殊符号\n\n&copy; &  &uml; &trade; &iexcl; &pound;\n&amp; &lt; &gt; &yen; &euro; &reg; &plusmn; &para; &sect; &brvbar; &macr; &laquo; &middot;\n\nX&sup2; Y&sup3; &frac34; &frac14;  &times;  &divide;   &raquo;\n\n18&ordm;C  &quot;  &apos;\n\n# Emoji表情 :satisfied:\n* 马：:horse:\n* 星星：:star2:\n* 笑脸：:smile:\n* 跑步：:running:\n\n# 数学公式\n\n行间公式：\n$$\\sin(\\alpha)^{\\theta}=\\sum_{i=0}^{n}(x^i + \\cos(f))$$\n行内公式 $E=mc^2$\n\n# 绘图\n## 时序图\n\n```mermaid\nsequenceDiagram\n\n  Alice->>John: Hello John, how are you?\n  loop Healthcheck\n      John->>John: Fight against hypochondria\n  end\n  Note right of John: Rational thoughts!\n       John-->>Alice: Great!\n       John->>Bob   : How about you?\n       Bob-->>John  : Jolly good!\n```\n\n\n## 状态图\n\n```mermaid\nstateDiagram\n\n    [*]-->Active\n    state Active {\n        [*]-->NumLockOff\n        NumLockOff-->NumLockOn : EvNumLockPressed\n        NumLockOn-->NumLockOff : EvNumLockPressed\n        --\n        [*]-->CapsLockOff\n        CapsLockOff-->CapsLockOn : EvCapsLockPressed\n        CapsLockOn-->CapsLockOff : EvCapsLockPressed\n        --\n        [*]-->ScrollLockOff\n        ScrollLockOff-->ScrollLockOn : EvCapsLockPressed\n        ScrollLockOn-->ScrollLockOff : EvCapsLockPressed\n            }\n```', '2022-09-18 20:53:01', '2022-09-18 20:53:01', 0, 3391, 1, NULL, 1, 0, 0, 1);

-- ----------------------------
-- Table structure for tb_blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_tag`;
CREATE TABLE `tb_blog_tag`  (
  `blog_id` bigint(20) NOT NULL COMMENT '文章 ID',
  `tag_id` bigint(20) NOT NULL COMMENT '标签 ID',
  PRIMARY KEY (`blog_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章-标签表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_blog_tag
-- ----------------------------
INSERT INTO `tb_blog_tag` VALUES (14, 1);
INSERT INTO `tb_blog_tag` VALUES (14, 2);
INSERT INTO `tb_blog_tag` VALUES (15, 3);
INSERT INTO `tb_blog_tag` VALUES (16, 1);
INSERT INTO `tb_blog_tag` VALUES (16, 2);
INSERT INTO `tb_blog_tag` VALUES (17, 2);
INSERT INTO `tb_blog_tag` VALUES (17, 3);
INSERT INTO `tb_blog_tag` VALUES (17, 4);
INSERT INTO `tb_blog_tag` VALUES (18, 3);

-- ----------------------------
-- Table structure for tb_blog_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_type`;
CREATE TABLE `tb_blog_type`  (
  `id` tinyint(20) NOT NULL AUTO_INCREMENT,
  `blog_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_blog_type
-- ----------------------------
INSERT INTO `tb_blog_type` VALUES (1, '原创');
INSERT INTO `tb_blog_type` VALUES (2, '转载');
INSERT INTO `tb_blog_type` VALUES (3, '翻译');

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类名',
  `pid` bigint(20) NULL DEFAULT -1 COMMENT '父分类id，如果没有父分类为-1',
  `description` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态0:正常,1禁用',
  `create_by` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_by` bigint(20) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT 0 COMMENT '删除标志（0代表未删除，1代表已删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES (1, 'java', -1, NULL, '0', NULL, NULL, NULL, NULL, 0);
INSERT INTO `tb_category` VALUES (2, 'Markdown', -1, NULL, '0', NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for tb_files
-- ----------------------------
DROP TABLE IF EXISTS `tb_files`;
CREATE TABLE `tb_files`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名称',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `size` double NULL DEFAULT NULL COMMENT '文件大小kb',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下载链接',
  `md5` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件md5',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除，0未删除',
  `enable` tinyint(1) NULL DEFAULT 1 COMMENT '是否应用，1，应用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_files
-- ----------------------------
INSERT INTO `tb_files` VALUES (1, '1', NULL, NULL, NULL, '1', NULL, NULL);
INSERT INTO `tb_files` VALUES (2, 'AY4DBY~NJOV]3H$N}(L{(P8.png', 'png', 40, 'http://localhost:8001/file/73a6ec7eacf44da5a8733b56249ce6da.png', '2ae7729449aab7c3da72e0e79d15610e', 0, 1);
INSERT INTO `tb_files` VALUES (3, 'AY4DBY~NJOV]3H$N}(L{(P8.png', 'png', 40, 'http://localhost:8090/file/ce94d9b8eb534747b84b191f768d3f74.png', '2ae7729449aab7c3da72e0e79d15610e', 0, 1);
INSERT INTO `tb_files` VALUES (4, 'AY4DBY~NJOV]3H$N}(L{(P8.png', 'png', 40, 'http://47.108.90.61:8090/file/4a9125755c674cc8afc14e686163768c.png', '2ae7729449aab7c3da72e0e79d15610e', 0, 1);
INSERT INTO `tb_files` VALUES (5, 'AY4DBY~NJOV]3H$N}(L{(P8.png', 'png', 40, 'http://47.108.90.61:8090/file/170bc0d86473453ebe5171508919e62d.png', '2ae7729449aab7c3da72e0e79d15610e', 0, 1);
INSERT INTO `tb_files` VALUES (6, 'AY4DBY~NJOV]3H$N}(L{(P8.png', 'png', 40, 'http://47.108.90.61:8090/blog/file/44f8968923834171883ae5f320db6f76.png', '2ae7729449aab7c3da72e0e79d15610e', 0, 1);
INSERT INTO `tb_files` VALUES (7, 'AY4DBY~NJOV]3H$N}(L{(P8.png', 'png', 40, 'http://localhost:8090/blog/file/0616cf41bcdc4d3ba0a9b772e2e64f33.png', '2ae7729449aab7c3da72e0e79d15610e', 0, 1);
INSERT INTO `tb_files` VALUES (8, 'CZ2QQO@P(6U~BSA`TH`VMYJ.png', 'png', 357, 'http://localhost:8090/blog/file/f601f89a13804285985dd14dbd5b4080.png', 'aa9009fb14e4b92176c06e219c364ea6', 0, 1);
INSERT INTO `tb_files` VALUES (9, 'CZ2QQO@P(6U~BSA`TH`VMYJ.png', 'png', 357, 'http://localhost:8090/blog/file/f6c78d24dc3f46089b0173c4e9ec267e.png', 'aa9009fb14e4b92176c06e219c364ea6', 0, 1);
INSERT INTO `tb_files` VALUES (10, 'CZ2QQO@P(6U~BSA`TH`VMYJ.png', 'png', 357, 'http://localhost:8090/blog/file/bc2708f4e06845b28b818a6c273df7ea.png', 'aa9009fb14e4b92176c06e219c364ea6', 0, 1);
INSERT INTO `tb_files` VALUES (11, 'CZ2QQO@P(6U~BSA`TH`VMYJ.png', 'png', 357, 'http://localhost:8090/blog/file/89a349921ea343a5a950078248f6f411.png', 'aa9009fb14e4b92176c06e219c364ea6', 0, 1);

-- ----------------------------
-- Table structure for tb_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_tag`;
CREATE TABLE `tb_tag`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标签名',
  `create_by` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_by` bigint(20) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT 0 COMMENT '删除标志（0代表未删除，1代表已删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '标签表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_tag
-- ----------------------------
INSERT INTO `tb_tag` VALUES (1, 'sql', NULL, NULL, NULL, NULL, 0);
INSERT INTO `tb_tag` VALUES (2, 'java', NULL, NULL, NULL, NULL, 0);
INSERT INTO `tb_tag` VALUES (3, 'js', NULL, NULL, NULL, NULL, 0);
INSERT INTO `tb_tag` VALUES (4, '设计模式', NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` tinyint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
