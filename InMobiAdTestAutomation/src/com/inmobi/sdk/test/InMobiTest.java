package com.inmobi.sdk.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidWebDriver;

import com.inmobi.sdk.test.config.TestCaseTags;
import com.inmobi.sdk.test.helper.FileReadWrite;
import com.inmobi.sdk.test.helper.ReadTestcase;
import com.inmobi.sdk.test.helper.TestCaseData;
import com.inmobi.sdk.test.helper.TestCaseListData;
//import org.openqa.selenium.android.AndroidDriver;
//import org.openqa.selenium.android.AndroidWebDriver;
//
//import com.android.sprout.admob.test.common.SproutXMLParser;
//import com.android.sprout.admob.test.extendedObjects.TestcaseData;
//import com.android.sprout.admob.test.extendedObjects.TestcaseListData;
import com.jayway.android.robotium.solo.Solo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.KeyEvent;

@SuppressWarnings("rawtypes")
public class InMobiTest  extends ActivityInstrumentationTestCase2  {
	
	private static String TARGET_PACKAGE_ID = "com.inmobi.sample370";
	//private static String LAUNCHER_ACTIVITY_NAME = "com.inmobi.androidsdk.com.inmobi.activity.LauncherActivity360";
	private static String LAUNCHER_ACTIVITY_NAME = "com.inmobi.sample.LauncherActivity";
	private static Class<?> launcherClass;
	private static Instrumentation inst;
	private static Activity mActivity;
	
	private static boolean firstRun = true;
	private static int testcaseIndex = -1;
	TestCaseListData testCaseListData ;
	
	private static Context myApp;  
	
	static {
		try {
			//Log.d("**** ROBO ****", "Static class");
			
			launcherClass = Class.forName(LAUNCHER_ACTIVITY_NAME);
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	@SuppressLint("NewApi")
	@SuppressWarnings("unchecked")
	public InMobiTest() throws Exception{
		super(launcherClass);
		inst = getInstrumentation();

	}
	

	private Solo solo;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		//Log.d("**** ROBO ****", "setup");
		if(inst == null)
			inst = getInstrumentation();
		mActivity = getActivity();
		myApp = inst.getContext();
		solo = new Solo(inst, mActivity);
		
		if(firstRun) {
            firstRun = false;
            Log.d("testcase firstrun", "firstrun");
            testcaseIndex++;
        }
		Log.d("TestCaseTags.TestCase.getName() : " , TestCaseTags.TestCase.getName().toString());
		
//		SproutXMLParser sp = new SproutXMLParser();
//		sp.readXMLData("Sprout_td_template_1.xml");
		ReadTestcase readTestCase = new ReadTestcase();
		testCaseListData = readTestCase.readXMLData("InMobiTest.xml");
//		readTestCase.readXMLData("InMobiTest.xml");
		
		Log.d("test.getTestcaseCount()", testCaseListData.getTestcaseCount().toString());
//		Log.d("test.getTestcaseCount()", test.getTestcaseCount());
		testCaseListData.resetIndex();
		TestCaseData td1 =  testCaseListData.getTestcaseDataFromMap(0);
		
//		Log.d("td1.getAdType()", td1.getAdType());
		Log.d("td1222.getAdType()", td1.getAndroidOS());
		Log.d("td1.getCta()", td1.getCta());
		Log.d("td1.getCta_url()", td1.getCta_url());
		Log.d("td1.getId()", td1.getId());
		Log.d("td1.getSdk()", td1.getSdk());
		
		
		td1 =  testCaseListData.getTestcaseDataFromMap(1);
		
		Log.d("td1.getAdType()", td1.getAdType());
		Log.d("td1.getAdType()", td1.getAndroidOS());
		Log.d("td1.getCta()", td1.getCta());
		Log.d("td1.getCta_url()", td1.getCta_url());
		Log.d("td1.getId()", td1.getId());
		Log.d("td1.getSdk()", td1.getSdk());
		
		td1 =  testCaseListData.getTestcaseDataFromMap(2);
		
		Log.d("td1.getAdType()", td1.getAdType());
		Log.d("td1.getAdType()", td1.getAndroidOS());
		Log.d("td1.getCta()", td1.getCta());
		Log.d("td1.getCta_url()", td1.getCta_url());
		Log.d("td1.getId()", td1.getId());
		Log.d("td1.getSdk()", td1.getSdk());
		
//		FileReadWrite.writeToSDFile("a", false);
		
		
	}
	

	
	public void test_1() throws Exception {
		
		
		TestCaseData testCaseData =  testCaseListData.getTestcaseDataFromMap(0);
		
		String testCaseName = testCaseData.getId();
		
		solo.waitForText("appid");
		solo.clickOnText("appid");
//		Thread.sleep(5000);
		solo.takeScreenshot(testCaseName + "_A");
//		Thread.sleep(5000);
		solo.waitForText("Load Banner");
		solo.clearEditText(0);
		solo.enterText(0, testCaseData.getAdUrl());
		solo.clickOnText("Load Banner");
//		Thread.sleep(10000);
		solo.waitForText("Refresh Ad");
		solo.takeScreenshot(testCaseName + "_B");
		Thread.sleep(35000);
		solo.takeScreenshot(testCaseName + "_C");
		Log.d("click", "Banner1");
		solo.clickOnScreen(366, 314);
		Thread.sleep(35000);
		solo.takeScreenshot(testCaseName + "_D");
		Log.d("click", "Banner");
		Thread.sleep(35000);
		solo.clickOnScreen(366, 314);
		
		Thread.sleep(35000);
		Log.d("click", "Int");
		solo.takeScreenshot(testCaseName + "_E");
		Thread.sleep(10000);
		solo.clickOnScreen(366, 314);
		Log.d("click", "Land");
		Thread.sleep(35000);
		solo.takeScreenshot(testCaseName + "_F");
		Thread.sleep(10000);
		
		FileReadWrite.writeToSDFile(testCaseName + ";" + 
									testCaseName + "_A" + ";" +
									testCaseName + "_B" + ";" +
									testCaseName + "_C" + ";" +
									testCaseName + "_D" + ";" +
									testCaseName + "_E" + ";" +
									testCaseName + "_F",false);
		
		}
		
		
		

		protected void tearDown() throws Exception {
			solo.finishOpenedActivities();
		  }
			
	public void test_2() throws Exception {
		
		TestCaseData testCaseData =  testCaseListData.getTestcaseDataFromMap(1);
		
		String testCaseName = testCaseData.getId();
		
			solo.clickOnText("appid");
			Thread.sleep(10000);
			solo.takeScreenshot(testCaseName + "_A");
			solo.clearEditText(0);
			solo.enterText(0, testCaseData.getAdUrl());
			solo.clickOnText("Load Interstitial");
			Thread.sleep(30000);
			solo.takeScreenshot(testCaseName + "_B");
			Thread.sleep(55000);
			solo.takeScreenshot(testCaseName +"_C");
			solo.clickOnScreen(200, 200);
			Thread.sleep(35000);
			solo.takeScreenshot(testCaseName +"_D");
			
			FileReadWrite.writeToSDFile(testCaseName + ";" + 
										testCaseName + "_A" + ";" +
										testCaseName + "_B" + ";" +
										testCaseName + "_C" + ";" +
										testCaseName + "_D" + ";" ,true);

		}

	 public void test_3() throws Exception {
			
			TestCaseData testCaseData =  testCaseListData.getTestcaseDataFromMap(2);
			
			String testCaseName = testCaseData.getId();
			
			solo.clickOnText("appid");
			Thread.sleep(5000);
			solo.takeScreenshot(testCaseName + "_A");
			solo.clearEditText(0);
			solo.enterText(0, testCaseData.getAdUrl());
			solo.clickOnText("Load Banner");
			Thread.sleep(10000);
			solo.takeScreenshot(testCaseName + "_B");
			Thread.sleep(15000);
			solo.takeScreenshot(testCaseName + "_C");
			solo.clickOnScreen(366, 314);
			Thread.sleep(35000);
			solo.takeScreenshot(testCaseName + "_D");
			Thread.sleep(10000);
			solo.clickOnScreen(366, 314);
			Thread.sleep(35000);
			solo.takeScreenshot(testCaseName + "_E");
//			FileReadWrite.writeToSDFile("b",true);
			
			FileReadWrite.writeToSDFile(testCaseName + ";" + 
										testCaseName + "_A" + ";" +
										testCaseName + "_B" + ";" +
										testCaseName + "_C" + ";" +
										testCaseName + "_D" + ";" +
										testCaseName + "_E" + ";",true);

		
	}
		

}
