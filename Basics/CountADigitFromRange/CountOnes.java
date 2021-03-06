package CountADigitFromRange;

public class CountOnes {
	static {
		long startTime = System.currentTimeMillis();
		int ans[] = new int[Integer.MAX_VALUE  / 4];
		int count = 0;
		for(int num = 1; num < ans.length; num++) {
			int c = 0;
			String s = String.valueOf(num);
			for(int i = 0; i < s.length(); i++) if(s.charAt(i) == '1') c++;
			count += c;
			ans[num] = count;
		}
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
	}
	
	
	
	public static void main(String[] args) {
	}
	
}
