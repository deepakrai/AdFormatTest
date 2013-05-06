import java.io.*;
import java.util.*;

public class HtmlReportGenerator
{

    public HtmlReportGenerator()
    {
    }

    public static void main(String args[]) throws Exception
    {
        String location = args[0];
        String imageFileExtension = args[1];

        BufferedReader reader = new BufferedReader(new FileReader(new File(location)));
        String line = null;
        int success = 0;
	ArrayList<String> sessionIdList = new ArrayList<String>();
	int total = 0;
	int timeTaken = 0;
	Map<String, Map<Integer, Integer>> mapSdkTime = new HashMap<String, Map<Integer, Integer>>();

	String htmlReport="\n";
	String htmlReportTestcaseHeaderTemplate="<h3>%TEST_CASE_NAME%</h3>\n<div style=\"border-top:2px solid #000;margin:8px 0px\"></div>";
	String htmlReportTestcaseImageTemplate="<img src=\"%TEST_CASE_IMAGE%\" width=\"15%\" />&nbsp;&nbsp;";
	String htmlReportTestcaseFooterTemplate="<br><br>";
        while((line = reader.readLine()) != null) 
        {

            String splits[] = line.split(";");
	//	    if (sessionIdExists(sessionIdList, splits[0].toString().trim()))
            if (splits.length > 2 )
            {
                htmlReport += "\n" + htmlReportTestcaseHeaderTemplate.replace("%TEST_CASE_NAME%",splits[0]) + "\n";
		for (int i = 1 ; i < splits.length ; i ++ ) {
			htmlReport += htmlReportTestcaseImageTemplate.replace("%TEST_CASE_IMAGE%",splits[i] + "." + imageFileExtension) + "\n";
		}
		htmlReport += htmlReportTestcaseFooterTemplate + "\n";

            }

        }
        reader.close();

	System.out.println(htmlReport);
    }

    public static boolean sessionIdExists(List sessionIdList, String sessionId)
    {
       for (int i = 0; i < sessionIdList.size(); i++) {
        if (sessionIdList.get(i).equals(sessionId)) 
            return true;
        }
    	return false;
    }

}
