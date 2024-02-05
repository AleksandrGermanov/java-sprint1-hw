chcp 65001
pushd %~dp0
javac -encoding utf8 -d ./jar ./src/*.java
cd jar
jar cfe StepTracker.jar Main *.class
del *.class
java -jar StepTracker.jar