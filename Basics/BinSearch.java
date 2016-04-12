// import org.junit.*;
// import static org.junit.Assert.*;
// import java.util.*;

public class BinSearch{
	public static void main(String[] args){
		//System.out.println("Test");
		int nums[] = {2,5,6,19};
		int target = 7;
		//find the first element smaller than or equal to target
		System.out.println(binSearch(nums, target));
		//System.out.println(" l = " + l + " r = " + r);
		//testBinSearch();
	}
	//find the last element smaller than or equal to target
	//or equivalently, the first element bigger than target,  minus 1
	public static int binSearch(int[] nums, int target){
		int l = 0, r = nums.length - 1;
		int position = -1;
		while(l <= r){
			int mid = l + (r - l) / 2; //it's possible that mid == left
			//System.out.println(" l = " + l + " r = " + r + " mid = " + mid);
			if(nums[mid] > target) {
				//mid is valid answer, move upper bound
				position = mid;
				r = mid - 1;
			} 
			else {
				l = mid + 1;
			}

		}
		System.out.println(" l = " + l + " r = " + r);
		System.out.println("found nums[r] = " + nums[r]);
		return position;
		//if (pos == -1) p
		//System.out.println(l - 1);
	}
	//@Test
  //  public static void testBinSearch(){
		// int nums[] = {1,1,1,1,2,2,2};
		// int target = 0;
  //     	assertEquals(-1, binSearch(nums,target));
  //  }
}