package LeetCodeJava;

public class DecodeWays {
	public static void main(String[] args) {
		System.out.println(numDecodings("10"));
	}
	public static int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        if(s.length() == 2) {
        	if(Integer.parseInt(s) <= 26) return 2;
        	else return 1;
        }
        return numDecodings(s.substring(0,1)) * numDecodings(s.substring(1)) + 
        		numDecodings(s.substring(0,2)) * numDecodings(s.substring(2));
        		
    }
}