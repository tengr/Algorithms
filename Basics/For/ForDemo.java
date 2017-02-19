package For;

import java.util.Arrays;

public class ForDemo {
	public static void main(String [] args){
		for(int i = 0, j = 3, k[] = {1,2,3}; k[2] != 9 ; i++, j--) {
			System.out.println("i = " + i + " j = " + j);
			System.out.println(Arrays.toString(k));
			k[0] += i;
			k[1] += j;
			k[2] += j;
		}
	}
}
