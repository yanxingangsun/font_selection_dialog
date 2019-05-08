REM 先在IDE下Build后生成了class文件，再执行本文件来创建Jar包
del /s/q classes lib\javafx 非模块字体对话框fxAll.jar
rd /S /q lib\javafx  

mkdir lib\javafx 
cd lib\javafx

jar xf ..\..\..\openjfx12.0.1库\win64\javafx-sdk-12.0.1\lib\javafx.base.jar
jar xf ..\..\..\openjfx12.0.1库\win64\javafx-sdk-12.0.1\lib\javafx-swt.jar
jar xf ..\..\..\openjfx12.0.1库\win64\javafx-sdk-12.0.1\lib\javafx.base.jar
jar xf ..\..\..\openjfx12.0.1库\win64\javafx-sdk-12.0.1\lib\javafx.controls.jar
jar xf ..\..\..\openjfx12.0.1库\win64\javafx-sdk-12.0.1\lib\javafx.fxml.jar
jar xf ..\..\..\openjfx12.0.1库\win64\javafx-sdk-12.0.1\lib\javafx.graphics.jar
jar xf ..\..\..\openjfx12.0.1库\win64\javafx-sdk-12.0.1\lib\javafx.media.jar 
jar xf ..\..\..\openjfx12.0.1库\win64\javafx-sdk-12.0.1\lib\javafx.swing.jar
jar xf ..\..\..\openjfx12.0.1库\win64\javafx-sdk-12.0.1\lib\javafx.web.jar
copy ..\..\..\openjfx12.0.1库\win64\javafx-sdk-12.0.1\bin\*.dll . /Y
del META-INF\MANIFEST.MF & del module-info.class 

cd ..\..
 
xcopy /S build\classes\. lib\javafx\

jar --create --file=非模块字体对话框fxAll.jar --main-class=测试.启动 -C lib/javafx .

java -jar 非模块字体对话框fxAll.jar
