asno=$1
if [ -z $asno ]
then
	echo "Enter Assignment Number"
	read asno
fi
rm -rf "Assignment $asno"
mkdir "Assignment $asno"
mkdir "Assignment $asno/input/"
mkdir "Assignment $asno/output/"
cd "Assignment $asno"
wget -r -nd -A java --accept-regex ".*\.java" "https://courses.eas.asu.edu/cse205/current/assignments/assignment$asno/Assignment$asno.java"
cd "input/"
for i in `seq 1 4`;
do
	wget "https://courses.eas.asu.edu/cse205/current/assignments/assignment$asno/input$i.txt"
done
cd "../output/"
for i in `seq 1 4`;
do
	wget "https://courses.eas.asu.edu/cse205/current/assignments/assignment$asno/output$i.txt"
done
code "../"

./gitcommit.sh
