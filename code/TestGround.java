package SortingTest;
import java.io.File;

public class TestGround {
	public static void main(String[] agrs){
		System.out.println("test");
		File[] files = new File("./").listFiles();
		for(File f : files){
			System.out.println(f);
		}
	}
}
