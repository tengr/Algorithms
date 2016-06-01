package CodeWithGoogleAustralia;

import java.math.BigInteger;
import java.util.Scanner;

public class Q3 {
	private static final long mod = 1000000007;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int i = 0; i < testCase; i++) {
			System.out.println(solve(sc.nextInt(),sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
	}
	
	public static long solve(int x1, int y1, int x2, int y2){
		long[][] table = new long[x2+1][y2+1];
		long ret = 0;
		//System.out.println("debug .." + table[x1][y1]);
		for(int x = x1; x <= x2; x++){
			for(int y = y1; y <= y2; y++){
				ret += calc(x,y);
				ret %= mod;
				//System.out.println("debug"  +ret + "table" + table[x][y]);
			}
		}
		//for(int i = x1; i <= x2; i++) System.out.println(Arrays.toString(table[i]));
		return ret;
	}
	
	public static long calc(int x, int y) {
		int N = x + y;
		int K = x;
//		long ret = 1;
//		int big = Math.max(x,y);
//		int small = Math.min(x,y);
//		
//		for(int i = x + y; i > big; i--) {
//			ret *= i % mod;
//			ret  = ret % mod;
//		}
//		
//		long divisor = 1;
//		
//		for(int i = small; i >= 1; i--) {
//			divisor *= i;
//		}
		
		BigInteger ret = BigInteger.ONE;
	    for (int k = 0; k < K; k++) {
	        ret = ret.multiply(BigInteger.valueOf(N-k))
	                 .divide(BigInteger.valueOf(k+1));
	    }
	    ret.mod(BigInteger.valueOf(mod));
	    return ret.longValue();
		
		//return (long) (ret * Math.pow(divisor, mod - 2)) % mod ;
		//return ret / divisor;
	}
}
