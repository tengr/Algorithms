package GeekForGeeks;

import java.util.Scanner;


public class CountDigitTest {
	public static void main(String[] args) {
		CountDigitTest ins = new CountDigitTest();
		Scanner sc = new Scanner(System.in);
		ins.input(sc);
		
	}
	public void input(Scanner sc) {
		int digit= -1, N = -1;
		do{
			System.out.println("digit = ");
			digit = sc.nextInt();
			System.out.println("range = ");
			N = sc.nextInt();
		}
		while(digit < 0 || digit > 9 || N < 0);
		
		
		CountDigitInRange bruteforce = new CountDigitInRange(){
			@Override
			public int countinRange(int digit, int N) {
				if (N < 0) return 0;
				int ret = 0;
				char c = (char)('0' + digit);
				for(int num = 0; num <= N; num++){
					String s = String.valueOf(num);
					for(int i = 0; i < s.length(); i++) {
						if(s.charAt(i) == c) ret++;
					}
 				}
				return ret;
			}
			
		};
		CountDigitInRange efficient = new CountDigitInRange(){
			@Override
			public int countinRange(int digit, int range) {
				int ret = 0;
				int N = range;
				int pow = 1;
				int count = 0;
				int preCount = 0;
				//for each loop iteration counting the digit occurrence of that specific position
				do {
					int d = N % 10;
					int currentDigitCount = 0;
					if(d > digit) currentDigitCount = pow;
					else if(d == digit) currentDigitCount = range % pow + 1;
					count =  currentDigitCount + (d - digit + 1) * preCount;
					ret += count;
					preCount = count;
					N /= 10;
					pow *= 10;
				} while (N > 0);
				return ret;
			}
			
		};
		System.out.println("Result  for digit count of " + digit +  " in range 0 - " + N);
		System.out.println("bruteforce: " + bruteforce.countinRange(digit, N));
		System.out.println("efficient: " + efficient.countinRange(digit, N));
	}
}
