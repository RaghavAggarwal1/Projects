asno=$1
clear
printf "Welcome,\n"
printf "                                                 _                             _                              _                      \n"
printf "                                                | |                           | |                            | |                     \n"
printf "   ___ _ __ _____      ___ __     __ _ _ __ ___ | |__   __ _ ___ ___  __ _  __| | ___  _ __   _ __ __ _  __ _| |__   __ ___   __     \n"
printf "  / __| \'__/ _ \ \ /\ / / \'_ \   / _\` | \'_ \` _ \| \'_ \ / _\` / __/ __|/ _\` |/ _\` |/ _ \| \'__| | \'__/ _\` |/ _\` | \'_ \ / _\` \ \ / /     \n"
printf " | (__| | | (_) \ V  V /| | | | | (_| | | | | | | |_) | (_| \__ \__ \ (_| | (_| | (_) | |    | | | (_| | (_| | | | | (_| |\ V /      \n"
printf "  \___|_|  \___/ \_/\_/ |_| |_|  \__,_|_| |_| |_|_.__/ \__,_|___/___/\__,_|\__,_|\___/|_|    |_|  \__,_|\__, |_| |_|\__,_| \_/       \n"
printf "                                                                                                         __/ |                       \n"
printf "                                                                                                        |___/                        \n"
printf "                                                                                                                                      \n"
if [ -z $asno ]
then
echo "Please Enter Assignment Number"
read asno
fi
if [ -d "Assignment $asno" ]
then
cd "Assignment $asno"
rm -rf myoutputs/
mkdir myoutputs/
for i in $(ls *.java);
do
echo "Compiling $i"
javac $i
done
for i in `seq 1 4`;
do
java Assignment$asno < input/input$i.txt > myoutputs/$i.txt
done
for i in `seq 1 4`;
do
echo "Verifying Testcase $i";
OUT="$(cmp myoutputs/$i.txt output/output$i.txt)"
echo ${OUT}
if [$OUT == ""]; then
echo "Testcase $i Correct!"
fi
done
else
echo "Assignment $asno directoery not found! Now Downloading Assignment Files"
./dl.sh $asno
fi

sh ../gitcommit.sh
