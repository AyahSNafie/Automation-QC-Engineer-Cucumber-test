package HelpingMethods;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextExtractor {

    // Method to extract the record count from a string
    public static int extractRecordCount(String recordCountText, String phrase) {
        
        int startIndex = recordCountText.indexOf("(");
		int endIndex = recordCountText.indexOf(phrase) + phrase.length();
		String extractedText = "";

		if (startIndex != -1 && endIndex != -1) {
		    extractedText = recordCountText.substring(startIndex, endIndex).trim();
		    System.out.println("Extracted text: " + extractedText);
		}
		
		//extractedText = "(2) Records Found"; 

		String regex = "\\((\\d+)\\) Records Found";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(extractedText);

		int recordCount = 0; 
		
		if (matcher.find()) {
		    // Extract the number as a string and convert to integer
		    recordCount = Integer.parseInt(matcher.group(1));
		}

		System.out.println("Record count: " + recordCount);
		
		return recordCount;
    }
    
    
}
