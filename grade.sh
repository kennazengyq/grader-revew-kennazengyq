CPATH='.:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar'

rm -rf student-submission
git clone $1 student-submission
echo 'Finished cloning'

cd student-submission
if [[ -f ListExamples.java ]]
then
    echo "ListExamples is found"
else
    echo "Need file ListExamples"
    exit 1
fi

cd ../
cp TestListExamples.java student-submission
cd student-submission

javac -cp ".;../lib/hamcrest-core-1.3.jar;../lib/junit-4.13.2.jar" *.java 2> output.txt

if [[ $? -eq 0 ]]
then
echo "Compile success"
else
echo "Compile error"
fi

java -cp ".;../lib/junit-4.13.2.jar;../lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore TestListExamples > output.txt
if [[ $? -eq 0 ]]
then
    echo "Passed all tests"
else
    echo "Failed some tests"
    cat output.txt
fi
