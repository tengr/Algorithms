import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
public class RegexDemo {
	public static void main(String[] args) {

		        Pattern pattern = Pattern.compile("^.*?([A-Z][a-z].*)$");

		        String original = "THIS IS A TEST - - +++ This is a test";
		        String replaced = pattern.matcher(original).replaceAll("$1");
		        
		        System.out.println("$1");

		        System.out.println(replaced);
		    
		
	 }
	
	public static void test1() {
		final String[] XML_FILTER = {
				"(.*)\\(.*)"
 		};	
		
		final Pattern[] patterns = new Pattern[XML_FILTER.length];
		for(int i = 0; i < patterns.length; i++) {
			patterns[i] = Pattern.compile(XML_FILTER[i]);
		}
		
		
		
		String filePath = "/Users/ruichen/Documents/Karin_Project/read_annotation/dict_output/go.xml";
		 Scanner sc = null;
		 try{
			 sc = new Scanner(new BufferedReader(new FileReader(filePath)));
	         while (sc.hasNext()) {
	        	 	String line = sc.nextLine();
	        	 	for(Pattern pattern : patterns) {
	        	 		Matcher m = pattern.matcher(line);
	        	 		if(m.matches()) {
	        	 			System.out.println("----------------");
	        	 			System.out.println(line);
	        	 			System.out.println(m.groupCount());
	        	 			for(int i = 0; i <= m.groupCount(); i++) {
	        	 				System.out.println(m.group(i));
	        	 			}
	        	 			System.out.println("----------------");
	        	 		}
	        	 		if(m.matches()) {
	        	 int len = line.length();
	        	 for(String regex : XML_FILTER) {	
	        	 		line = line.replaceAll(regex, "");
	        	 }
//	        	 line = line.replaceAll("<em>","");
//	        	 line = line.replaceAll("</em>", "");
//	        	 line = line.replaceAll(" EXACT.*","/>");
//	        	 if(line.length() != len) System.out.println(line);
	        	 		}
	        	 	}
	         }
		 } catch (FileNotFoundException e) {
			 e.printStackTrace();
	        } finally {
	            if (sc != null) {
	                sc.close();
	            }
	        }
	}
		
}
