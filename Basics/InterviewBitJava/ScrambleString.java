package InterviewBitJava;

public class ScrambleString {
	public static void main(String[] args){
		ScrambleString ins = new ScrambleString();
		System.out.println(ins.isScramble("rgeat", "great"));
	}
	public int isScramble(final String a, final String b) {
	    if(a.length() != b.length()) return -1;
	    for(int start = 0, end = 0; end <= a.length(); ){
	    	if(end == a.length()) {
	            if(!isValid(a,b,start,end - 1)) return 0;
	            else return 1;
	    	}
	        if(isValid(a,b,start,end - 1)){
//	        	System.out.println(a.substring(start,end));
//	        	System.out.println(b.substring(start,end));
//	        	System.out.println("--------------------");
	            start = end;
	            end++;
	        }
	        else end++;

	    } 
	    return 1;
	}
	
	public boolean isValid(final String a, final String b, int start, int end) {
//	    if(start > end) return true;
//	    boolean same = true, reverse = true;
//	    for(int i = start, j = end; i < a.length(); i++, j--) {
//	    	if(reverse && i < j) {
//	    		if(a.charAt(i) != b.charAt(j)) reverse = false;
//	    	}
//	    	if(same) {
//	    		if(a.charAt(i) != b.charAt(i)) same = false;
//	    	}
//	    	if(!same && !reverse) return false;
//	    }   
//	    return true;
		if(start > end) return true;
		StringBuilder sb = new StringBuilder(a.substring(start,end+1));
		return a.substring(start,end+1).equals(b.substring(start,end+1)) ||
				sb.reverse().toString().equals(b.substring(start,end+1));
	}
}
