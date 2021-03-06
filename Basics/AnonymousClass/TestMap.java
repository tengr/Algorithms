package AnonymousClass;

import java.util.Arrays;

	public class TestMap {
		public static void main(String[] args) {
			Integer []arr = new Integer[3];
			Arrays.fill(arr, 3);
			System.out.println("named class");			
			Function<Integer, Integer> f = new Function<Integer, Integer>(){
				@Override
				public Integer func(Integer input) {
					return input * input;
				}

			};
			Map<Integer, Integer> map = new Map<Integer, Integer>();
			System.out.println(Arrays.toString(map.map(f, arr)));
			System.out.println("=======================");	
			System.out.println("Anonymous class");			
			System.out.println(Arrays.toString(map.map(new Function<Integer, Integer>(){
				@Override
				public Integer func(Integer input) {
					return input * input;
				}

			}, arr)));
			System.out.println("=======================");	
			System.out.println("Lamda Expression");			
			System.out.println(Arrays.toString(map.map((a)->{System.out.println("lambda int to int");
			return a + a;}, arr)));
			System.out.println("=======================");	
			System.out.println("Lamda Expression");	
			Map<Integer, String> map2 = new Map<Integer, String>();
			System.out.println(Arrays.toString(map2.map((a)->{System.out.println("lambda int to str");
			return a + "hello World" + a;}, arr)));
			System.out.println("=======================");	
			
	}
}
