package com.inmobi.sdk.test.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;
import android.util.Xml;

//import com.android.sprout.admob.test.InMobiMainTest;
//import com.android.sprout.admob.test.common.SproutTags;
import com.inmobi.sdk.test.InMobiTest;
import com.inmobi.sdk.test.config.TestCaseTags;

public class ReadTestcase {
	private static final String ns = null;
	public TestCaseData testCaseData;
	private TestCaseListData testCaseListData;
	private Map<Short, TestCaseData> testcaseMap =  new HashMap<Short, TestCaseData>();

	
	public TestCaseListData readXMLData( String fileName) throws Exception  {
//		InputStream inputStream = InMobiTest.class
//				.getResourceAsStream(fileName);
//		
//		Log.d("tag", "asd");
//		
//		XmlPullParser parser = Xml.newPullParser();
//		parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
//		parser.setInput(inputStream, null);
//		
//		skipTag(parser, 2); // move pointer to 2nd tag i.e. Configs tag
//		parser.require(XmlPullParser.START_TAG, ns,
//				TestCaseTags.TestCase.getName());
//		while (parser.next() != XmlPullParser.END_DOCUMENT) {
//			/*
//			 * if (parser.getEventType() == XmlPullParser.END_TAG) continue;
//			 * else
//			 */
//			if (parser.getEventType() == XmlPullParser.START_TAG) {
//				if (parser.isEmptyElementTag())
//					continue;
//				parserTestCaseXML(parser);
//			}
//		}
//		inputStream.close();

//		if (mainAdFileName == null || mainAdFileName.trim().length() < 1)
//			throw new Exception(
//					"Name of xml file having main creative is missing.");
//		else {
////			inputStream = new FileInputStream(
////					mContext.getFileStreamPath(mainAdFileName));
//			
//			inputStream = InMobiMainTest.class
//					.getResourceAsStream(mainAdFileName);
//			parser.setInput(inputStream, null);
//			parserMainAdXML(parser);
//			inputStream.close();
//		}
//
//
//		String adType = inputData.getAdType();
//		if (adType.equalsIgnoreCase("Expandable")
//				|| adType.equalsIgnoreCase("ClickToRich")) {
//			if (expandedFileName == null
//					|| expandedFileName.trim().length() < 1)
//				throw new Exception(
//						"Name of xml file having Expandable / Click to rich creative is missing.");
//
//			parseExpandableData(parser); // TO BE IMPLEMENTED
//		}
		
		InputStream inputStream = InMobiTest.class
				.getResourceAsStream(fileName);
		
		XmlPullParser parser = Xml.newPullParser();
		parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
		parser.setInput(inputStream, null);
		skipTag(parser, 2); // move pointer to 2nd tag i.e. TestCase tag
		System.out.println("TestCaseTags.TestCase.getName() : " + TestCaseTags.TestCase.getName().toString());
		Log.d("TestCaseTags.TestCase.getName() : " , TestCaseTags.TestCase.getName().toString());
		parser.require(XmlPullParser.START_TAG, ns,
				TestCaseTags.TestCase.getName());
		
		testCaseListData = new TestCaseListData();	
		parseTestCaseData(parser);
		
		testCaseListData.resetIndex();
		inputStream.close();
		
		return testCaseListData;
	}
	
	
	private void parseTestCaseData(XmlPullParser parser) throws Exception {
		String tagName = parser.getName();
		
//		while (parser.next() != XmlPullParser.END_DOCUMENT) {
		do {
			if (parser.getEventType() == XmlPullParser.START_TAG) {
				if (parser.isEmptyElementTag())
					continue;
				parseTestCaseTag(parser);
			} else if (parser.getEventType() == XmlPullParser.END_TAG
					&& parser.getName().equalsIgnoreCase(
							TestCaseTags.TestCase.getName())) {
				testCaseListData.addIntoTestcaseListDataMap(testCaseData);
				
				testCaseData = null;
			}
		}
		while (parser.next() != XmlPullParser.END_DOCUMENT) ;
		
	}
	
	
	private static void skipTag(XmlPullParser parser, int count)
			throws XmlPullParserException, IOException {
		for (int i = 0; i < count; i++) {
			parser.nextTag();
		}
	}
	
//	private static void parserTestCaseXML(XmlPullParser parser) throws Exception {
//		skipTag(parser, 2); // move pointer to 2nd tag i.e. Pages tag
//		parser.require(XmlPullParser.START_TAG, ns, TestCaseTags.TestCase.getName());
//		while (parser.next() != XmlPullParser.END_DOCUMENT) {
//			if (parser.getEventType() == XmlPullParser.START_TAG) {
//				if (parser.isEmptyElementTag())
//					continue;
//				parseTestCaseTag(parser);
////			} else if (parser.getEventType() == XmlPullParser.END_TAG
////					&& parser.getName().equalsIgnoreCase(
////							SproutTags.Page.getName())) {
////				inputData.addIntoPageDataMap(testCaseData.getPageIndex(), testCaseData);
////				testCaseData = null;
//			}
//		}
//	}
	
	private void parseTestCaseTag(XmlPullParser parser) throws Exception {
//		String tagName = parser.getName();
//		short pageIndex = -1;
//		if (tagName.equalsIgnoreCase(TestCaseTags.Page.getName())) {
//			testCaseData = new TestCaseData();
//			pageIndex = Short.valueOf(parser.getAttributeValue(ns, "id")
//					.substring(1));
//			testCaseData.setPageIndex(pageIndex);
//		} else if (tagName.equalsIgnoreCase(SproutTags.NextPageTap.getName())) {
//			testCaseData.setNextPageTap(readText(parser));
//		} else if (tagName.equalsIgnoreCase(SproutTags.PageTestType.getName())) {
//			testCaseData.setPageTestType(readText(parser));
//		} else if (tagName.equalsIgnoreCase(SproutTags.Image.getName())) {
//			parseImageTag(parser, pageIndex);
//		} else if (tagName.equalsIgnoreCase(SproutTags.Audio.getName())) {
//			parseAudioTag(parser, pageIndex);
//		} else if (tagName.equalsIgnoreCase(SproutTags.Video.getName())) {
//			parseVideoTag(parser, pageIndex);
//		} else if (tagName.equalsIgnoreCase(SproutTags.Form.getName())) {
//			parseFormTag(parser, pageIndex);
//		}
		
		String tagName = parser.getName();
		Log.d("tagName", tagName);
		String testcaseId = "";
		if (tagName.equalsIgnoreCase(TestCaseTags.TestCase.getName())) {
			testCaseData = new TestCaseData();
			testcaseId = parser.getAttributeValue(ns, "id");
			testCaseData.setId(testcaseId);
		} else if (tagName.equalsIgnoreCase(TestCaseTags.SDK.getName())) {
			testCaseData.setSdk(readText(parser));
		} else if (tagName.equalsIgnoreCase(TestCaseTags.AndroidOS.getName())) {
			testCaseData.setAndroidOS(readText(parser));
		} else if (tagName.equalsIgnoreCase(TestCaseTags.AdType.getName())) {
			testCaseData.setAdType(readText(parser));
		} else if (tagName.equalsIgnoreCase(TestCaseTags.CTA.getName())) {
			testCaseData.setCta(readText(parser));
		} else if (tagName.equalsIgnoreCase(TestCaseTags.CTA_URL.getName())) {
			testCaseData.setCta_url(readText(parser));
		} else if (tagName.equalsIgnoreCase(TestCaseTags.AdUrl.getName())) {
			testCaseData.setAdUrl(readText(parser));
		}

	}
	
	private String readText(XmlPullParser parser)
			throws XmlPullParserException, IOException {
		String result = "";
		if (parser.next() == XmlPullParser.TEXT) {
			result = parser.getText();
			Log.d("result", result);
			parser.nextTag();
		}
		return result;
	}
	
	
//	public void readXMLData( String fileName)
//			throws Exception {
//		// FileInputStream fis = new
//		// FileInputStream(mContext.getFileStreamPath(fileName));
//
//		InputStream inputStream = InMobiTest.class
//				.getResourceAsStream(fileName);
//		
//		XmlPullParser parser = Xml.newPullParser();
//		parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
//		parser.setInput(inputStream, null);
//		skipTag(parser, 2); // move pointer to 2nd tag i.e. Configs tag
//		parser.require(XmlPullParser.START_TAG, ns,
//				SproutTags.Configs.getName());
//		while (parser.next() != XmlPullParser.END_DOCUMENT) {
//			/*
//			 * if (parser.getEventType() == XmlPullParser.END_TAG) continue;
//			 * else
//			 */
//			if (parser.getEventType() == XmlPullParser.START_TAG) {
//				if (parser.isEmptyElementTag())
//					continue;
//				parseConfigsData(parser);
//			}
//		}
//		inputStream.close();
//
//		if (mainAdFileName == null || mainAdFileName.trim().length() < 1)
//			throw new Exception(
//					"Name of xml file having main creative is missing.");
//		else {
////			inputStream = new FileInputStream(
////					mContext.getFileStreamPath(mainAdFileName));
//			
//			inputStream = InMobiMainTest.class
//					.getResourceAsStream(mainAdFileName);
//			parser.setInput(inputStream, null);
//			parserMainAdXML(parser);
//			inputStream.close();
//		}
//
//
//		String adType = inputData.getAdType();
//		if (adType.equalsIgnoreCase("Expandable")
//				|| adType.equalsIgnoreCase("ClickToRich")) {
//			if (expandedFileName == null
//					|| expandedFileName.trim().length() < 1)
//				throw new Exception(
//						"Name of xml file having Expandable / Click to rich creative is missing.");
//
//			parseExpandableData(parser); // TO BE IMPLEMENTED
//		}
//	}
}
