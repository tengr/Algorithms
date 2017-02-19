package MoveZeros;
import java.util.Random;
public class MoveZeros {

	public static void main(String[] args) {
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			System.out.println(r.nextInt(10));
		}
	}
	
	public int bfCount(int[] arr) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) count++;
		return count;
	}
	

	

}
