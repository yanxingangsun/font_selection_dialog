REM ����IDE��Build��������class�ļ�����ִ�б��ļ�������Jar��
del /s/q classes lib\javafx ��ģ������Ի���fxAll.jar
rd /S /q lib\javafx  

mkdir lib\javafx 
cd lib\javafx

jar xf ..\..\..\openjfx12.0.1��\win64\javafx-sdk-12.0.1\lib\javafx.base.jar
jar xf ..\..\..\openjfx12.0.1��\win64\javafx-sdk-12.0.1\lib\javafx-swt.jar
jar xf ..\..\..\openjfx12.0.1��\win64\javafx-sdk-12.0.1\lib\javafx.base.jar
jar xf ..\..\..\openjfx12.0.1��\win64\javafx-sdk-12.0.1\lib\javafx.controls.jar
jar xf ..\..\..\openjfx12.0.1��\win64\javafx-sdk-12.0.1\lib\javafx.fxml.jar
jar xf ..\..\..\openjfx12.0.1��\win64\javafx-sdk-12.0.1\lib\javafx.graphics.jar
jar xf ..\..\..\openjfx12.0.1��\win64\javafx-sdk-12.0.1\lib\javafx.media.jar 
jar xf ..\..\..\openjfx12.0.1��\win64\javafx-sdk-12.0.1\lib\javafx.swing.jar
jar xf ..\..\..\openjfx12.0.1��\win64\javafx-sdk-12.0.1\lib\javafx.web.jar
copy ..\..\..\openjfx12.0.1��\win64\javafx-sdk-12.0.1\bin\*.dll . /Y
del META-INF\MANIFEST.MF & del module-info.class 

cd ..\..
 
xcopy /S build\classes\. lib\javafx\

jar --create --file=��ģ������Ի���fxAll.jar --main-class=����.���� -C lib/javafx .

java -jar ��ģ������Ի���fxAll.jar
