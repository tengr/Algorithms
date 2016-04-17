
public class RotateArray {
	public static void main(String[] args){
		int a[] = {1,2,3,4,5};
		int num[] = rotate(a, 3);
		//for(int i = 0; i < num.length; i++) System.out.print(num[i] + " ");
	}
	public static int[] rotate(int nums[], int k){
		int preIndex = 0;
		int preVal = nums[preIndex];
		while(true){
			int nextIndex = (preIndex + k) % nums.length;
			System.out.println(" preIndex = " + preIndex + " nextIndex = " + nextIndex);
			int temp = nums[nextIndex];
			nums[nextIndex] = preVal;
			preVal = temp;
			preIndex = nextIndex;
			if (preIndex == 0) break;
		}
		//rotate 1 k times
		//copy last k elements to the front	
		return nums;
	}
}
