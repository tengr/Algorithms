package InterviewBitJava;

import java.util.Arrays;
import java.util.List;

public class Inverse {
	public static void main(String[] args) {
		Inverse ins = new Inverse();
		//test single arr
		System.out.println(Arrays.asList(1));
		System.out.println(ins.countInverse(Arrays.asList(1)));
		//test sorted
		System.out.println(Arrays.asList(1,2,3));
		System.out.println(ins.countInverse(Arrays.asList(1,2,3)));
		//test unsorted
		System.out.println(Arrays.asList(1,4,2,5,3,6));
		System.out.println(ins.countInverse(Arrays.asList(1,4,2,5,3,6)));
	}
	
	public int countInverse(final List<Integer> a) {
		int[] arr = Arrays.stream((Integer[])a.toArray()).mapToInt(Integer::intValue).toArray();
		int ret = mergeCount(arr, 0, arr.length - 1);
		System.out.println("sorted:" + Arrays.toString(arr));
		return ret;
	}
	//end indexes always inclusive
	public int mergeCount(int[] arr, int start, int end) {
		if(start >= end) return 0;
		int mid = start + (end - start) / 2;
		return mergeCount(arr, start, mid) + mergeCount(arr, mid + 1, end) + merge(arr, start, mid + 1, end);
	}
	
	public int merge(int[] arr, int s1, int s2, int end){
		//s1 .. s2-1, s2 .. end
		int count = 0;
		int[] temp = new int[end - s1 + 1];
		for(int i = s1, j = s2, k = 0; i < s2 || j < end + 1; ){
			if(j == end + 1 || i < s2 && arr[i] <= arr[j]) temp[k++] = arr[i++];
			else {
				temp[k++] = arr[j++];
				count += s2 - i;
			}
		}
		for(int i = s1; i < end + 1; i++) arr[i] = temp[i-s1];
		return count;
	}
}
