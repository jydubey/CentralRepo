package central.TestCases;

import java.io.File;
import java.util.Date;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class Time {

	public static void main(String[] args) {
		
		
		/*
		 * Calendar calendar = Calendar.getInstance(); Date currentDateTime =
		 * calendar.getTime(); System.out.println(currentDateTime);
		 */
		
//		Calendar calendar = Calendar.getInstance();
//		calendar.add(Calendar.DAY_OF_YEAR, 10);
//		Date futureDateTime = calendar.getTime();
//		System.out.println(futureDateTime);
//		int count=84 ;
	//	
		//for (int i = 80; i < count; i++)
			//{
			  //System.out.println(i);
			//}
		Date date=new Date();
        System.out.println(date.toString().replaceAll(":", "-"));
        String reportsFolder=date.toString().replaceAll(":", "-")+"//screenshots";
        String path= System.getProperty("user.dir")+"//Reports//"+reportsFolder;
        System.out.println(path);
        File f=new File(path);
        f.mkdirs();
        

	}

}
