@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run

REM compile the code into the bin folder
javac  -cp \Users\fch\Desktop\2113\duke-gradle-1\master\src\main\java -Xlint:none -d ..\bin \Users\fch\Desktop\2113\duke-gradle-1\master\src\main\java\Duke.java
IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)

REM no error here, errorlevel == 0

REM run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath \Users\fch\Desktop\2113\duke-gradle-1\master\bin Duke < input.txt > ACTUAL.TXT

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT

PAUSE