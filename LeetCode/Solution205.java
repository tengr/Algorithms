//Longest Substring with At Most Two Distinct Characters

public class Solution205{
	public static String findLongest(String s){
		if (s == null) return "";
		if (s.length() == 0 || s.length() == 1) return s;

		//int maxLen = 1;
		//int [] record = new int(s.length());
		int start = 0; //start of possible result to previous char
		int preConsec = 1; // consecutive same char from previous char
		char first = s.charAt(0), second = '\u0000';
		String res = "";

		for(int i = 1; i < s.length(); i++){
			char curr = s.charAt(i);

			if (curr == first) {
				//same character
				//record[i] = start;
			}
			else if (second == '\u0000' || curr == second){
				//second character
				second = curr;
				//record[i] = start;
			}
			else {
				//third character
				if(res.length() < i - start) res = s.substring(start, i);

				first = s.charAt(i-1);
				second = s.charAt(i);
				start = i - preConsec;
				//record[i] = start;
				//third character
			}

			if(curr == s.charAt(i - 1)) preConsec++;
			else preConsec = 1;
		}

		if(res.length() < s.length() - start) res = s.substring(start, s.length());

		return res;
	}

	public static void main(String[] args){
		String testString = "abbcc";
		System.out.println("the result of " + testString + " is " + findLongest(testString));
	}
}