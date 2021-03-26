set -e
cd "$(dirname "$0")"
export CCHK="java -classpath /ulib/java/antlr-4.9.1-complete.jar:./bin Main -semantic"
cat > test.mx
$CCHK
