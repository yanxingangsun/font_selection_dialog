# 字体选择对话框

#### 介绍
Swing版和JavaFX版的字体选择对话框，可以做为库直接拿来使用。

#### 软件架构
Swing版本的一个文件；
JavaFX版本界面部分独立成两个文件：FXML和控制器。


#### 安装教程

下载解压缩，用NetBeans11打开即可。

#### 使用说明

1. Swing版本导入库后，调用只用下面一句代码：
```
字体对话框.显示()；//返回java.awt.Font对象，详情可参见main函数
```

2. JavaFX版导入库后，调用需三句代码：

```
//返回javafx.scene.text.Font对象，详情可参见"测试.测试界面"
字体对话框 dialog=new 字体对话框();
Optional<Font> result = dialog.showAndWait();
result.ifPresent(f -> {System.out.println(f);}); 
```

#### 软件截图

1. ![输入图片说明](https://images.gitee.com/uploads/images/2019/0508/092154_f26ae497_76449.png "font1.png")
2. ![输入图片说明](https://images.gitee.com/uploads/images/2019/0508/092223_3ed7a3f0_76449.png "font2.png")

#### JavaFX的字体设置说明


- 1、JavaFX的控件基本上不支持中文字体的加粗，斜体和粗斜体；而且很多字体对英文的加粗，斜体和粗斜体也不支持。

- 2、Subscene不能设置字体，Group和Node（Label、Button、Text等控件）可以设置字体。

- 3、Group只能通过setStyle设置字体：

```
group.setStyle("-fx-font-family: 'FangSong';-fx-font-size: 16;");
//设置后，对容器内子控件也有效。
```


- 4、Node（Label、Button、Text等控件）两种方式设置字体：

```
node.setStyle("-fx-font-family: 'FangSong';-fx-font-size: 16;");
node.setFont(Font.font("FangSong"));
```


- 5、API:

```
setFont(Font font)
Font.font(String family, FontWeight weight, FontPosture posture, double size)
Font.font(String family, FontWeight weight, double size)
Font.font(String family, FontPosture posture, double size)
Font.font(String family, double size)
Font.font(String family)
Font.font(double size)
```


- 6、字体样式：
如仿宋，不能写仿宋、Fong Song等，必须写字体样式标准英文中应用格式。

```
黑体：SimHei
新宋体：NSimSun
仿宋：FangSong
楷体：KaiTi
仿宋_GB2312：FangSong_GB2312
楷体_GB2312：KaiTi_GB2312
微軟正黑體：Microsoft JhengHei
微软雅黑体：Microsoft YaHei
装Office会生出来的一些：
隶书：LiSu
幼圆：YouYuan
华文细黑：STXihei
华文楷体：STKaiti
华文宋体：STSong
华文中宋：STZhongsong
华文仿宋：STFangsong
方正舒体：FZShuTi
方正姚体：FZYaoti
华文彩云：STCaiyun
华文琥珀：STHupo
华文隶书：STLiti
华文行楷：STXingkai
华文新魏：STXinwei

```

- 注：因为JavaFX不支持中文字体的变化，这就是为什么中文字体的名称也全部用英文的原因了。
