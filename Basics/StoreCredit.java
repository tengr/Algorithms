import java.util.Arrays;
import java.util.Scanner;


public class StoreCredit {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int C = sc.nextInt(), I = sc.nextInt();
			int[] v = new int[I];
			for(int idx = 0; idx < I; v[idx++] = sc.nextInt()) ;
			System.out.println("Case #"+ (i+1) + ": " + solve(v, C));
		}
	}
	public static String solve(int[] v, int C) {
		int[] idxRec = new int[2000];
		for(int i = 0; i < v.length; i++) {
			if(C - v[i] > 0 && idxRec[C-v[i]] > 0) return idxRec[C-v[i]] + " " + (i+1);
			else idxRec[v[i]] = i+1;
		}
		return null;
	}
}
