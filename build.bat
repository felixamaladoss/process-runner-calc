rmdir /Q /S build

mkdir build

javac src\uk\ac\process\*.java
ECHO Compiled !!

ECHO Copying buid files
xcopy src build /E /H /I

cd build

jar cfe processing-unit.jar uk.ac.process.ProcessingUnit uk/ac/process/*.class
ECHO Jar created under 'build' - processing-unit.jar
cd ..