public class CountSmaller {
   public static void main(String[] args) {
    int nums[] = {5,2,6,1};
    countSmaller(nums);
   }

    public static void countSmaller(int[] nums) {
        int counts[] = new int[nums.length]; // count for elements smaller than it afterwards

        int indices[] = new int[nums.length]; // indeces of nums;
            
        for(int i = 0; i < nums.length; i++) indices[i] = i;

        mergeSort(nums, indices, counts);
        
        System.out.println("\nsorted indices = ");
        for(int i = 0; i < nums.length; i++) System.out.print(nums[indices[i]] + " ");
     

        
//        for(int i = 0; i < nums.length; i++) {
//        	//for num position indices[i]
//        	//nums.length - indices[i] is how many indices are larger than me
//        	//nums.lenght - i is how many elements are larger than or equal to me
//        	//i is how many elements are smaller or equal to me
//        	//indices[i] is how many indices are smaller than me
//        	// i - indices[i] is how many elements are smaller or equal to me but their indices are larger than me
//        	
//        	counts[indices[i]] = i - indices[i];
////        	for(int k = i - 1; k >=0; k--) {
////        		if(nums[indices[i]] == nums[indices[k]]) counts[i]--;
////        	}
//        }
        System.out.println("\ncounts = ");
        for(int i = 0; i < nums.length; i++) System.out.print(counts[i] + " ");
        //return new ArrayList<Integer>();
    }
    
    public static void mergeSort(int nums[], int [] indices, int [] counts){
		mergeSort(nums, indices, 0, nums.length, counts);
	}
    //OK, still merge sort, now we store indices instead of actual number
    public static void merge(int[] nums, int [] indices, int s1, int e1, int s2, int e2, int [] counts) {
        System.out.println(" s1 = " + s1 + " e1 = " + e1 + " s2 = " + s2 + " e2 = " + e2 );
        int temp[] = new int[e1 - s1 + e2 - s2];
        int i = s1, j = s2;
        int k = 0;
        int total = 0;
        while(i < e1 && j < e2) {
            if (nums[indices[i]] < nums[indices[j]]) { 
            	//temp[k] = nums[i];
                temp[k] = indices[i];
                
                //if(indices[i] > indices[j]) counts[indices[j]]++;
                counts[indices[i]] += total;
                k++;i++;
            }
            else if(nums[indices[i]] > nums[indices[j]]) {
            	temp[k] = indices[j];
            	total++;
            	//if(indices[i] < indices[j]) counts[indices[i]]++;
            	
            	k++;
            	j++;
            }                        
            //else means an element in the second array is smaller than first array
            else {
                //temp[k] = nums[j]; 
            	temp[k] = indices[j];
                k++; j++; 
            }
        }
        if (i == e1) while(j < e2) {
        	temp[k] = indices[j];
        	//if(indices[e1 - 1] > indices[j] && nums[indices[e1 - 1]] < nums[indices[j]]) counts[indices[j]]++;
            k++; j++;
        }
        else while(i < e1) {
        	temp[k] = indices[i];
        	counts[indices[i]] += total;
            //if(indices[i] < indices[e2 - 1] && nums[indices[i]] > nums[indices[e2 - 1]]) counts[indices[i]]++;
            k++;i++;
        }
        for(i = s1, k = 0; i < e2; i++, k++) {
        	indices[i] = temp[k];
        }
    }    
	
    public static void mergeSort(int[] nums, int [] indices, int start, int end, int[] counts) {
        if (start >= end - 1) return;
        mergeSort(nums, indices, start, start + (end - start) / 2, counts); //end is not inclusive
        mergeSort(nums, indices, start + (end - start) / 2, end, counts);
        merge(nums, indices, start, start + (end - start) / 2, start + (end - start) / 2, end, counts);
    }
    
}