import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int i = 1; i <= testCase; i++) {
			int B = sc.nextInt();
			int M = sc.nextInt();
			char[][] conn = new char[B][B];
			for(int idx = 0; idx < B; idx++) Arrays.fill(conn[idx], '0');
			if(!solve(B, M, conn))
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			else{
				System.out.println("Case #" + i + ": POSSIBLE");
				for(int idx = 0; idx < B; idx++) System.out.println(String.valueOf(conn[idx]));
			}

    	}
	    sc.close();
    	
    }
	
	
	public static boolean solve(int B, int M, char[][] conn) {
		//exact (n-2) * (n - 1) / 2 for n nodes
		
		if ((B-2) * (B-1) / 2  + 1 < M) return false;
		
		for(int i = 0; i < B - 1; i++) conn[i][i+1] = '1';
		
		int count = 1;
		if(count == M) return true;
		
		for(int i = 0; i < B - 2; i++) {
			for(int j = i + 2; j < B; j++) {
				conn[i][j] = '1';
				count++;
				if(count == M) return true;
			}
		}
		return true;
	}
}
