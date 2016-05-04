import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;


public class Quicksort {
	public static void quicksort(int nums[]) {
		quicksort(nums, 0, nums.length);
	}

	public static void quicksort(int nums[], int start, int end) {
		if(start >= end - 1) return;
		int pivot = nums[end - 1]; //Hoarse partitioning
		int i = start, j = end - 2;
		while(true){
			while(i <= j && nums[i] <= pivot) i++;
			while(i <= j && nums[j] > pivot) j--;
			if(i > j) break;
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		nums[end - 1] = nums[i];
		nums[i] = pivot;
		quicksort(nums, start, i);
		quicksort(nums, i + 1, end);
		
	}
	
	public static void main(String[] args){
		int nums[] = {5,3,2,7,1};
		printNums(nums);
		quicksort(nums);
		printNums(nums);
		quicksortTest();
		
		int nums3[] = {2, 6, 3, 5, 1, 1, 8};
		int nums4[] = {12, 16, 333, 50, 1000, 5, 897, 1, 3, 66, 13 };
		int nums5[] = {1,1,1,2,2,2,3,3,3};
		printNums(nums3);
		quicksort(nums3);
		printNums(nums3);
		printNums(nums4);
		quicksort(nums4);
		printNums(nums4);
		quicksort(nums5);
		printNums(nums5);
	}

	public static void quicksortTest(){
		for(int time = 0; time < 200; time++){		
		    Random r = new Random();
		    int[] nums = new int[time];
		    int[] nums2 = new int[time];
		    for (int i = 0; i < nums.length; i++) {
		      nums[i] = r.nextInt();
		    }
		    
		    System.arraycopy(nums, 0, nums2, 0, nums.length );
		    Arrays.sort(nums);
		    quicksort(nums2, 0, nums2.length);
		    assertArrayEquals(nums,nums2);
		}

		System.out.println("Test Done!");
	}
	
	
	public static void printNums(int nums[]){
		for(int i = 0; i < nums.length; i++) System.out.print(nums[i] + " ");
		System.out.println();
	}
}
