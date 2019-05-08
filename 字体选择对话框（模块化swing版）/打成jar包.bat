rem 编译后可以打包成jar文件(需新建jar目录)
jar -cf 模块化字体对话框.jar -C build/modules/字体 . 
rem 下面是执行测试的
java -p 模块化字体对话框.jar -m 字体/字体.字体对话框