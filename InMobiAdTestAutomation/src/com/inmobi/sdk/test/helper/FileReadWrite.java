package com.inmobi.sdk.test.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import android.util.Log;

public class FileReadWrite {

	
	public static void writeToSDFile( String strData, Boolean boolAppend){
		File root = android.os.Environment.getExternalStorageDirectory(); 
//	    tv.append("\nExternal file system root: "+root);
	
	    // See http://stackoverflow.com/questions/3551821/android-write-to-sd-card-folder
	
	    File dir = new File (root.getAbsolutePath() + "/Robotium-Screenshots");
	    dir.mkdirs();
	    File file = new File(dir, "testData.txt");
	
	    try {
	        FileOutputStream f = new FileOutputStream(file, boolAppend);
	        PrintWriter pw = new PrintWriter(f);
//	        pw.println("Hi , How are you");
//	        pw.println("Hello");
	        pw.println(strData);
	        pw.flush();
	        pw.close();
	        f.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }   
	}
}
