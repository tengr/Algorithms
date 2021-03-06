import java.util.HashMap;

// //273. Integer to English Words
// 123 -> "One Hundred Twenty Three"
// 12345 -> "Twelve Thousand Three Hundred Forty Five"
// 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
public class NumbertoWords{
	public static void main(String[] args){
		System.out.println(numberToWords(112321678));
		System.out.println(numberToWords(1));
		System.out.println(numberToWords(21221212));
		System.out.println(numberToWords(2147483647));
		//System.out.println(numberToWords(4294967295));
		
	}

	//IT audit //controls processing improvement
	//forensic team //data discovery
	//technolgial adviosry // technical consulting //ea strategic
	public static String getSegment(int d00, int d0, int d, HashMap<Integer, String> map) {
		//this segment always starts with space
		String res = "";        
        if (d00 != 0) {
    		res += " " + map.get(d00) + " Hundred";
        }
        if(d0 == 0) return res + " " + map.get(d);
        else if(d0 == 1) return res + " " + map.get(d0 * 10 + d);
    	else {
    		//2 - 9
    		if (d == 0) return res + " " + map.get(d0 * 10);
    		else return res + " " + map.get(d0 * 10) + " " + map.get(d);
    	}

	}

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        HashMap<Integer,String> map = new HashMap<Integer, String>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Nighty");


        String res = "";
        int d00 = 0, d0 = 0, d = 0;
        int numDigit = 0;
        int comma = 0;
        while(num > 0) {
        	//System.out.println(num);
        	int digit = num % 10; numDigit++;num /= 10;
        	if(numDigit == 1) d = digit;
        	else if(numDigit == 2) d0 = digit;
        	else if(numDigit == 3) d00 = digit;
        	if(numDigit == 3 || num == 0) {
        		if (comma == 0) res = getSegment(d00, d0, d, map);
        		else if (comma == 1) res = getSegment(d00, d0, d, map) + " Thousand" + res;
        		else if (comma == 2) res = getSegment(d00, d0, d, map) + " Million" + res;
        		else if (comma == 3) res = getSegment(d00, d0, d, map) + " Billion" + res;
        		d00 = d0 = d = 0;
        		numDigit = 0;
        		comma++;
        		System.out.println(comma);
        	}
        }
        return res.trim();
    }
}