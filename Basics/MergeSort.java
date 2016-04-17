import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;
public class MergeSort{
	public static void main(String[] args){
		int nums[] = {5,3,2,7,1};
		printNums(nums);
		mergeSort(nums);
		printNums(nums);
		MergeSortTest();
		
		int nums3[] = {2, 6, 3, 5, 1, 1, 8};
		int nums4[] = {12, 16, 333, 50, 1000, 5, 897, 1, 3, 66, 13 };
		printNums(nums3);
		mergeSort(nums3);
		printNums(nums3);
		printNums(nums4);
		mergeSort(nums4);
		printNums(nums4);
	}

	public static void MergeSortTest(){
		for(int time = 0; time < 200; time++){		
		    Random r = new Random();
		    int[] nums = new int[time];
		    int[] nums2 = new int[time];
		    for (int i = 0; i < nums.length; i++) {
		      nums[i] = r.nextInt();
		    }
		    
		    System.arraycopy(nums, 0, nums2, 0, nums.length );
		    Arrays.sort(nums);
		    mergeSort(nums2, 0, nums2.length);
		    assertArrayEquals(nums,nums2);
		}

		System.out.println("Test Done!");
	}
	
	
	public static void printNums(int nums[]){
		for(int i = 0; i < nums.length; i++) System.out.print(nums[i] + " ");
		System.out.println();
	}

	public static void merge(int[] nums, int s1, int e1, int s2, int e2) {
        //System.out.println("e1 = " + e1 + " s1 = " + s1 + " e2 = " + e2 + " s2 = " + s2);
        int temp[] = new int[e1 - s1 + e2 - s2];
        int i = s1, j = s2;
        int k = 0;
        while(i < e1 && j < e2) {
            if (nums[i] < nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }
        if (i == e1) while(j < e2) temp[k++] = nums[j++];
        else while(i < e1) temp[k++] = nums[i++];
        for(i = s1, k = 0; i < e2; i++, k++) nums[i] = temp[k];
    }    
    
	public static void mergeSort(int nums[]){
		mergeSort(nums, 0, nums.length);
	}
	
    public static void mergeSort(int[] nums, int start, int end) {
        if (start >= end - 1) return;
        mergeSort(nums, start, start + (end - start) / 2); //end is not inclusive
        mergeSort(nums, start + (end - start) / 2, end);
        merge(nums,start, start + (end - start) / 2, start + (end - start) / 2, end);
    }
}