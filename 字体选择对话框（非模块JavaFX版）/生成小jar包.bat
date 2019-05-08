REM 先在IDE下Build后生成了class文件，再执行本文件来创建Jar包
jar -cf 非模块字体对话框fx.jar -C build/classes .
rem java -cp 非模块字体对话框fx.jar 测试.启动

java -cp ..\openjfx12.0.1库\win64\javafx-sdk-12.0.1\lib\javafx-swt.jar;..\openjfx12.0.1库\win64\javafx-sdk-12.0.1\lib\javafx.base.jar;..\openjfx12.0.1库\win64\javafx-sdk-12.0.1\lib\javafx.controls.jar;..\openjfx12.0.1库\win64\javafx-sdk-12.0.1\lib\javafx.fxml.jar;..\openjfx12.0.1库\win64\javafx-sdk-12.0.1\lib\javafx.graphics.jar;..\openjfx12.0.1库\win64\javafx-sdk-12.0.1\lib\javafx.media.jar;..\openjfx12.0.1库\win64\javafx-sdk-12.0.1\lib\javafx.swing.jar;..\openjfx12.0.1库\win64\javafx-sdk-12.0.1\lib\javafx.web.jar;非模块字体对话框fx.jar 测试.启动
