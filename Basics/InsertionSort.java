import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;


public class InsertionSort {
	public static void insertionSort(int [] nums) {
		if (nums == null || nums.length <= 1) return;
		for(int i = 1; i < nums.length; i++) {
			int j = i - 1;
			int valToInsert = nums[i];
			while(j >= 0 && valToInsert < nums[j]) {
				nums[j+1] = nums[j];
				j--;
			}
			nums[j+1] = valToInsert;
		}
	}
	
	public static void main(String[] args){
		int nums[] = {5,3,2,7,1};
		printNums(nums);
		insertionSort(nums);
		printNums(nums);
		insertionSortTest();
		
		int nums3[] = {2, 6, 3, 5, 1, 1, 8};
		int nums4[] = {12, 16, 333, 50, 1000, 5, 897, 1, 3, 66, 13 };
		int nums5[] = {1,1,1,2,2,2,3,3,3};
		printNums(nums3);
		insertionSort(nums3);
		printNums(nums3);
		printNums(nums4);
		insertionSort(nums4);
		printNums(nums4);
		insertionSort(nums5);
		printNums(nums5);
	}

	public static void insertionSortTest(){
		for(int time = 0; time < 200; time++){		
		    Random r = new Random();
		    int[] nums = new int[time];
		    int[] nums2 = new int[time];
		    for (int i = 0; i < nums.length; i++) {
		      nums[i] = r.nextInt();
		    }
		    
		    System.arraycopy(nums, 0, nums2, 0, nums.length );
		    Arrays.sort(nums);
		    insertionSort(nums2);
		    assertArrayEquals(nums,nums2);
		}

		System.out.println("Test Done!");
	}
	
	
	public static void printNums(int nums[]){
		for(int i = 0; i < nums.length; i++) System.out.print(nums[i] + " ");
		System.out.println();
	}
}
