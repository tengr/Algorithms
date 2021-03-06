
public class LCSubstring {
	public static void main(String[] args) {
		String a = "abab";
		String b = "baba";
		LCSubstring ins = new LCSubstring();
		System.out.println(ins.solve(a,b));
		
	}
	
	public String solve(String a, String b){
		int m = a.length(), n = b.length();
		int dp[][] = new int[m + 1][n + 1];
		int maxLen = 0;
		String res = null;
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(a.charAt(i - 1) == b.charAt(j - 1)){
					dp[i][j] = dp[i-1][j-1] + 1;
					if(dp[i][j] > maxLen) {
						res = b.substring(i - dp[i][j] + 1, i+1);
						maxLen = dp[i][j];
					}
 				}
				else dp[i][j] = 0;
			}
		}
		return res;
	}
}
