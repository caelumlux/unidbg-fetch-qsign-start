@echo off
set /p var=请输入要开启的版本(支持:8.9.50~8.9.88,Tim3.5.1/2/5,企点3.8.2)
bin\unidbg-fetch-qsign.bat --basePath=txlib\%var%
pause
