import java.util.Scanner;


public class BigSum {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		System.out.println(bigSum(a,b));
		System.out.println(a+b);
	}
	public static String bigSum(int a, int b) {
		int digitA = 0, digitB = 0, sum = 0, carry = 0;
		StringBuilder sb = new StringBuilder();
		while(true) {
			digitA = a % 10;
			digitB = b % 10;
			sum = digitA + digitB + carry;
			sb.append(sum % 10);
			carry = sum / 10;
			a /= 10;
			b /= 10;
			if( a== 0 && b == 0 && carry == 0) break;
		}
		return sb.reverse().toString();
	}
}
