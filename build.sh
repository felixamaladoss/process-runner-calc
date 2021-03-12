#!/bin/sh

# Author : Felix Xavier
# Build Java Proejct  
mkdir -p build

#Clean build if already present
rm -rf build/*

javac src/uk/ac/process/*.java
echo "Compiled !!"

echo "Copying buid files"
cp -r src/* build/.

cd build

jar cfe processing-unit.jar uk.ac.process.ProcessingUnit uk/ac/process/*.class
echo "Jar created under 'build' - processing-unit.jar"

