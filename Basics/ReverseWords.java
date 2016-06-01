import java.util.Scanner;


public class ReverseWords {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int i = 0; i < testCase; i++) {
			System.out.println("Case #" + (i+1) + ": "+ solve(sc.nextLine()));
		}
	}
	
	public static String solve(String s){
		char[] arr = s.toCharArray();
		reverse(arr, 0, arr.length - 1);
		boolean inWord = false;
		for(int i = 0, start = 0; i < arr.length + 1; i++){
			if(inWord && ( i == arr.length || arr[i] == ' ')) {
				reverse(arr, start, i-1);
				start = i+1;
				inWord = false;
			}
			else if(!inWord && i < arr.length && arr[i] != ' ') {
				start = i;
				inWord = true;
			}
		}
		return String.valueOf(arr);
	}
	
	public static void reverse(char[] arr, int start, int end) {
		for(int i = start, j = end; i < j; i++, j--){
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
}
