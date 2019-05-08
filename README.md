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

