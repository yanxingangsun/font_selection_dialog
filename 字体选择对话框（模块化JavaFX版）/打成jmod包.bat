del ģ�黯����Ի���fx.jmod
del /S /Q /F links
rd /S /Q links
rem �������Դ����jmod�ļ�
jmod create ģ�黯����Ի���fx.jmod --class-path build/modules/���� --module-version 1.0
rem ������ִ�в��Եġ���Ϊjmod�ļ�������������ʱ�ģ�����jlink������ģ���õġ�
jlink -p ..\..\openjfx12.0.1��\win64\javafx-jmods-12.0.1;ģ�黯����Ի���fx.jmod --add-modules=���� --output links 
links\bin\java -m ����/����.����