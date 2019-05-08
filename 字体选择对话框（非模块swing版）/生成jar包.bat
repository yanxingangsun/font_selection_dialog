REM 先在IDE下Build后生成了class文件，再执行本文件来创建Jar包
jar -cf 非模块字体对话框.jar -C build/classes .
java -cp 非模块字体对话框.jar 字体.字体对话框