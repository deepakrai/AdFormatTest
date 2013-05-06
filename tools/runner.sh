#! /bin/bash
adb shell am instrument -w com.inmobi.sdk.test/android.test.InstrumentationTestRunner



#line=`adb shell cat /sdcard/Robotium-Screenshots/testData.txt |  wc -l`
#while [ $(adb shell cat /sdcard/Robotium-Screenshots/testData.txt |  wc -l) -ne 2 ]
#do
#	echo $line
#	line=`adb shell cat /sdcard/Robotium-Screenshots/testData.txt |  wc -l`
#done


#sleep 10

TimeStarted=`date "+%d_%m_%Y-%H_%M_%S"`

mkdir $TimeStarted
adb  pull  /sdcard/Robotium-Screenshots/ $TimeStarted/
java  HtmlReportGenerator $TimeStarted/testData.txt jpg > $TimeStarted/Results.html

adb shell rm  /sdcard/Robotium-Screenshots/testData.txt



# convert -compress Zip Test_1_A.jpg  Test_1_B.jpg  Test_1_C.jpg  Test_1_D.jpg Test_1.pdf
# convert -compress Zip Test_2_A.jpg  Test_2_B.jpg  Test_2_C.jpg  Test_2_D.jpg Test_2.pdf

