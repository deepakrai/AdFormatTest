package com.inmobi.sdk.test.helper;

import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;

import android.util.Log;
import android.util.Xml;

//import com.android.sprout.admob.test.InMobiMainTest;
//import com.android.sprout.admob.test.common.SproutTags;
import com.inmobi.sdk.test.InMobiTest;

public class ReadTestcase {

	
	public static void readXMLData( String fileName) throws Exception  {
		InputStream inputStream = InMobiTest.class
				.getResourceAsStream(fileName);
		
		Log.d("tag", "asd");
		
		XmlPullParser parser = Xml.newPullParser();
		parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
		parser.setInput(inputStream, null);
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
