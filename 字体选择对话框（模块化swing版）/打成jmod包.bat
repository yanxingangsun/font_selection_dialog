del 模块化字体对话框.jmod
del /S /Q /F links
rd /S /Q links
rem 编译后可以打包成jmod文件
jmod create 模块化字体对话框.jmod --class-path build/modules/字体 --module-version 1.0
rem 下面是执行测试的。因为jmod文件不是用在运行时的，是在jlink做独立模块用的。
jlink -p 模块化字体对话框.jmod --add-modules=字体 --output links 
links\bin\java -m 字体/字体.字体对话框