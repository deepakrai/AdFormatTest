package com.inmobi.sdk.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidWebDriver;
import com.inmobi.sdk.test.helper.ReadTestcase;
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

public class InMobiTest  extends ActivityInstrumentationTestCase2  {
	
	private static String TARGET_PACKAGE_ID = "com.inmobi.sample370";
	//private static String LAUNCHER_ACTIVITY_NAME = "com.inmobi.androidsdk.com.inmobi.activity.LauncherActivity360";
	private static String LAUNCHER_ACTIVITY_NAME = "com.inmobi.sample.LauncherActivity";
	private static Class<?> launcherClass;
	private static Instrumentation inst;
	private static Activity mActivity;
	
	private static boolean firstRun = true;
	private static int testcaseIndex = -1;
	
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
		
//		SproutXMLParser sp = new SproutXMLParser();
//		sp.readXMLData("Sprout_td_template_1.xml");
//		ReadTestcase.readXMLData("sprout_td_template_11.xml");
		
	}
	
	
//	public TestcaseData getTestcase() throws Exception {
////		SproutXMLParser sp = new SproutXMLParser();
////		
////		TestcaseListData testcaseList =  sp.readTestCaseList( "TestCase.xml");
////		
////		testcaseList.setTestcaseIndex(testcaseIndex);
////		TestcaseData testcaseData1 = (TestcaseData) testcaseList.getTestcaseDataFromMap();
////		testcaseIndex++;
////		return testcaseData1;
//	}
	
	
	public void test_1() throws Exception {
		
		solo.clickOnText("appid");
		Thread.sleep(5000);
		solo.takeScreenshot();
		solo.clickOnText("Load Interstitial");
		Thread.sleep(30000);
		solo.takeScreenshot();
		Thread.sleep(5000);
		
		
//		SproutXMLParser sp = new SproutXMLParser();
//		
//		TestcaseData testcaseData1 = getTestcase();
//		sp.readXMLData( testcaseData1.getTestcasefileName());
//		
//		Log.d("TestCaseInfo" ,testcaseData1.getTestcaseId() + " - " + testcaseData1.getTestcasefileName());
//		
//		
//		//solo.takeScreenshot("ss1");
//		solo.clickOnText("InMobi Ad Testing");
//		Thread.sleep(5000);
//		//solo.takeScreenshot("ss2");
//		//solo.assertCurrentActivity("Activity not found.", expectedClass)
//		solo.clickOnText("Get Interstitial Ad");
//		Thread.sleep(10000);
//		solo.clickOnText("Show Interstitial Ad");
//		Thread.sleep(2000);
//		//solo.takeScreenshot("ss3");
//		/*WebView wv = null;
//		ArrayList<View> views = solo.getCurrentViews();
//		for(View v : views) {
//			if(v instanceof WebView) {
//				wv = (WebView) v;
//				//break;
//			}
//		}*/
//		
//		WebDriver driver = new AndroidWebDriver(mActivity);
//		driver.get("http://farm.sproutbuilder.com/load/oACpFexNOYE086Y7.inmobi.w.review.html");
//		WebElement webElement = driver.findElement(By.tagName("iframe"));
//		driver.switchTo().frame(webElement.getAttribute("id"));
//		webElement = driver.findElement(By.xpath("//span[text()='GOTO URL http://www.google.co.in/']"));
//		webElement.click();
//		
//		//solo.takeScreenshot("ss4");
//		Thread.sleep(2000);
//		
//		Thread.sleep(5000);
//		inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
	}
	

}
