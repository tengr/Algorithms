import static org.junit.Assert.*;
public class CountWord{
	public static void main(String [] args){
		//System.out.println(countWords()
		//System.out.println(countWords(new String(" a ").toCharArray()));
//		for (String s: new String("").split("\\s+")){
//			System.out.println("===" + s);
//		} 
		
		countWordsTest();
	}
	
	public static void countWordsTest(){
		String tests[] = {
			"a",
			" a",
			" a ",
			"a ",
			" a a ",
			"   ",
			"\n\n\t",
			" \t a \t ",
			null
		};

		for(String s : tests){
			//System.out.println(s);
			assertEquals(countWords(s.toCharArray()), s.trim().isEmpty() ? 0 : s.trim().split("\\s+").length );
		}
	}

	public static int countWords(char s[]) {
		if(s == null) return 0;
		Boolean inWord = false;
		int count = 0;
		for(int i = 0; i < s.length; i++) {
			if(!Character.isWhitespace(s[i])) inWord = true;
			else if(inWord) {
				count++;
				inWord = false;
			}
		}
		if(inWord) count++;
		return count;
	}
	
	public static int countWords2(char s[]) {
		if(s == null) return 0;
		boolean inWord = false;
		int count = 0;
		for(int i = 0; i < s.length; i++) {
			if(!Character.isWhitespace(s[i]) && !inWord) {
				inWord = true;
				count++;
			}
		}
		return count;
	}
}