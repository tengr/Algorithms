import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class A {
	static class Letter implements Comparable<Letter>{
		char c;
		int count;
		public Letter(int c, int count) {
			this.c = (char) ('A' + c);
			this.count = count;
		}
		@Override
		public int compareTo(Letter l) {
				if (this.count < l.count) return 1;
				else if(this.count == l.count) return 0;
				else return -1;
		}
		@Override
		public String toString(){
			return count + " " + c;
		}
		
	}
	
	public static void main(String[] args) {
		A ins = new A();
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int i = 1; i <= testCase; i++) {
        	int N = sc.nextInt();
        	ArrayList<Letter> list = new ArrayList<Letter>();
        	int sum  = 0;
        	for(int j = 0; j < N; j++) {
        		int count = sc.nextInt();
        		sum += count;
        		list.add(new Letter(j, count));
        	}
        	System.out.println("Case #" + i + ": " + ins.solve(list, sum, ""));
        	
        }
        sc.close();
    }
	
	public String solve(ArrayList<Letter> list, int sum, String prefix){
		if(sum == 0) return prefix.trim();
		Collections.sort(list);
		Letter first = list.get(0);
		Letter second = list.get(1);
		
		if(first.count > second.count) {
			first.count -= 1;
			return solve(list, sum - 1, prefix + first.c + " ");
		}
		else {
			if(list.size() == 2 || list.get(2).count <= (sum - 2) / 2) {
				first.count -= 1;
				second.count -= 1;
				return solve(list, sum - 2, prefix + first.c + second.c + " ");
			}
			else{
				first.count -= 1;
				return solve(list, sum - 1, prefix + first.c + " ");
			}
		}
	}
}
