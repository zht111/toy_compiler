set ff=unix
set -e
mkdir -p bin
find ./src -name *.java | javac -d bin -classpath "/ulib/java/antlr-4.9.1-complete.jar" @/dev/stdin