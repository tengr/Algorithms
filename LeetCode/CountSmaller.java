public class CountSmaller {
   public static void main(String[] args) {
    int nums[] = {5,2,6,1};
    countSmaller(nums);
   }


    public static void countSmaller(int[] nums) {
        int counts[] = new int[nums.length]; // count for elements smaller than it afterwards
        int indices[] = new int[nums.length]; // indeces of nums;
        int getOldPosFromNew[] = new int[nums.length]; //newPos[i] is the index in the new array of the element i in old array
        int getNewPosFromOld[] = new int[nums.length]; //oldPos[i] is the index in the old array of element i in the new array
        
        //oldPos[i] gets the index of the original array from the current array
        //newPos[i] gets the index of the current array from the original array
            
        for(int i = 0; i < nums.length; i++) {getOldPosFromNew[i] = i; indices[i] = i; getNewPosFromOld[i] = i;}//first off current array is the original array



        mergeSort(nums, indices, counts, getOldPosFromNew, getNewPosFromOld);
        System.out.println("new pos = ");
        for(int i = 0; i < nums.length; i++) System.out.print(getOldPosFromNew[i] + " ");
        System.out.println("\nold pos = ");
        for(int i = 0; i < nums.length; i++) System.out.print(getNewPosFromOld[i] + " ");
        System.out.println("\nsorted array = ");
        for(int i = 0; i < nums.length; i++) System.out.print(nums[indices[i]] + " ");
     
        System.out.println("\ncounts = ");
        for(int i = 0; i < nums.length; i++) System.out.print(counts[i] + " ");
        
        //return new ArrayList<Integer>();
    }
    
    public static void mergeSort(int nums[], int [] indices, int [] counts, int [] getOldPosFromNew, int [] getNewPosFromOld){
        mergeSort(nums, indices, 0, nums.length, counts, getOldPosFromNew, getNewPosFromOld);
    }
    //OK, still merge sort, now we store indices instead of actual number
    public static void merge(int[] nums, int [] indices, int s1, int e1, int s2, int e2, int [] counts, int[] getOldPosFromNew, int [] getNewPosFromOld) {
        System.out.println(" s1 = " + s1 + " e1 = " + e1 + " s2 = " + s2 + " e2 = " + e2 );
        int temp[] = new int[e1 - s1 + e2 - s2];
        int i = s1, j = s2;
        int k = 0;
        while(i < e1 && j < e2) {
            if (nums[indices[i]] < nums[indices[j]]) { 
                //temp[k] = nums[i];
                temp[k] = indices[i];
                
                if(indices[i] > indices[j]) counts[indices[j]]++;
                
                //i is the temporary new position, first get the old/original/fixed position, then define the latest new pos
                //getNewPosFromOld[getOldPosFromNew[i]] = s1 + k; 
                //latest s1 + k should point to wherever this element is originally from
                //getOldPosFromNew[s1 + k] = getOldPosFromNew[i];
                k++;i++;
            }
            else if(nums[indices[i]] > nums[indices[j]]) {
                temp[k] = indices[j];
                
                if(indices[i] < indices[j]) counts[indices[i]]++;
                
                k++;
                j++;
            }                        
            //else means an element in the second array is smaller than first array
            else {
                //temp[k] = nums[j]; 
                temp[k] = indices[j];
//                int tmp1 = getNewPosFromOld[getOldPosFromNew[j]];
//                int tmp2 = getOldPosFromNew[s1 + k];
//                getNewPosFromOld[getOldPosFromNew[j]] = s1 + k; 
//                getOldPosFromNew[s1 + k] = getOldPosFromNew[j];
                k++; j++; 
            }
        }
        if (i == e1) while(j < e2) {
            temp[k] = indices[j];
            if(indices[e1 - 1] > indices[j] && nums[indices[e1 - 1]] < nums[indices[j]]) counts[indices[j]]++;

            //            temp[k] = nums[j]; 
//            getNewPosFromOld[getOldPosFromNew[j]] = s1 + k; 
//            getOldPosFromNew[s1 + k] = getOldPosFromNew[j]; 
            k++; j++;
        }
        else while(i < e1) {
            temp[k] = indices[i];
            if(indices[i] < indices[e2 - 1] && nums[indices[i]] > nums[indices[e2 - 1]]) counts[indices[i]]++;

            //            temp[k] = nums[i]; 
//            getNewPosFromOld[getOldPosFromNew[i]] = s1 + k; 
//            getOldPosFromNew[s1 + k] = getOldPosFromNew[i];
            k++;i++;
        }
        for(i = s1, k = 0; i < e2; i++, k++) {
            indices[i] = temp[k];
//          nums[i] = temp[nums[k]];
//            nums[i] = temp[k];
//            getNewPosFromOld[getOldPosFromNew[i]] = s1 + k; 
//            getOldPosFromNew[s1 + k] = getOldPosFromNew[i];
        }
    }    
    
    public static void mergeSort(int[] nums, int [] indices, int start, int end, int[] counts, int [] getOldPosFromNew, int [] getNewPosFromOld) {
        if (start >= end - 1) return;
        mergeSort(nums, indices, start, start + (end - start) / 2, counts, getOldPosFromNew, getNewPosFromOld); //end is not inclusive
        mergeSort(nums, indices, start + (end - start) / 2, end, counts, getOldPosFromNew, getNewPosFromOld);
        merge(nums, indices, start, start + (end - start) / 2, start + (end - start) / 2, end, counts, getOldPosFromNew, getNewPosFromOld);
    }
    
}