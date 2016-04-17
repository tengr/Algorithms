import java.util.Scanner;

public class RevengeofthePancakes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		for (int t = 0; t < T; t++) {
			int count = 0;
			char[] inp = in.nextLine().toCharArray();
			for (int i = inp.length - 1; i >= 0; i--) {
				if (inp[i] == '-') {
					if (inp[0] == '+') {
						int j=0;
						while(inp[j]=='+'){
							j++;
						}
						inp = flip(inp, j-1);
						count++;
					}
					inp = flip(inp, i);
					count++;
					//System.out.println(inp);
				}
			}
			System.out.println("Case #" + (t + 1) + ": " + count);
		}

	}

	public static char[] flip(char[] inp, int end) {
		for (int i = 0; i <= end / 2; i++) {
			char temp = inp[i];
			inp[i] = inp[end - i] == '+' ? '-' : '+';
			inp[end - i] = temp == '+' ? '-' : '+';
		}
		return inp;
	}

}
