@echo off
setlocal
for /f "tokens=2 delims=:." %%x in ('chcp') do set _codepage=%%x
chcp 65001>nul
cd C:\Users\Ich\IdeaProjects\EAAHf\run
C:\Users\Ich\.gradle\jdks\eclipse_adoptium-21-amd64-windows\jdk-21.0.4+7\bin\java.exe @C:\Users\Ich\IdeaProjects\EAAHf\build\moddev\gameTestServerRunClasspath.txt @C:\Users\Ich\IdeaProjects\EAAHf\build\moddev\gameTestServerRunVmArgs.txt -Dfml.modFolders=eaahforge%%%%C:\Users\Ich\IdeaProjects\EAAHf\build\classes\java\main;eaahforge%%%%C:\Users\Ich\IdeaProjects\EAAHf\build\resources\main net.neoforged.devlaunch.Main @C:\Users\Ich\IdeaProjects\EAAHf\build\moddev\gameTestServerRunProgramArgs.txt
if not ERRORLEVEL 0 (  echo Minecraft failed with exit code %ERRORLEVEL%  pause)
chcp %_codepage%>nul
endlocal