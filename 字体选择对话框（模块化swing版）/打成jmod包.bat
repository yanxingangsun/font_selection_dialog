del ģ�黯����Ի���.jmod
del /S /Q /F links
rd /S /Q links
rem �������Դ����jmod�ļ�
jmod create ģ�黯����Ի���.jmod --class-path build/modules/���� --module-version 1.0
rem ������ִ�в��Եġ���Ϊjmod�ļ�������������ʱ�ģ�����jlink������ģ���õġ�
jlink -p ģ�黯����Ի���.jmod --add-modules=���� --output links 
links\bin\java -m ����/����.����Ի���