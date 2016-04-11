public class Solution {
    //this actually outputs the actual sequence
    //would incur time limit exceeded due to excessive output
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p[] = new int[nums.length + 1]; //predecessors
        int mark [] = new int[nums.length + 1]; // mark[i] - idx of smallest last element for any IS of length i so far
        for(int i = 0; i < nums.length + 1; i++) {mark[i] =-1; p[i] = -1;}
        mark[1] = 0;
        int maxLen = 1;
        for(int i = 1; i < nums.length; i++){
            //update with nums[i]
            /*nums[mark[]] is a non decreasing array, as if mark[i] < mark[i - 1], meaning there is a longer sequence (length i) ending with a smaller value nums[mark[i]], then mark[i - 1] is no longer the index of the smallest element of any IS of length i - 1, as removing any element from the IS of length i would generate a IS of length i - 1 with last element smaller then nums[mark[i - 1]], thus violating the assumption */
            /*update, nums[mark[]] should be a strictly increasing array, as if mark[i] = mark[i - 1], as IS has to be strictly increasing, meaning the second last element of IS of length i has to be smaller than mark[i-1], thus violating the assumption*/
            if (nums[i] > nums[mark[maxLen]]) {
                p[i] = mark[maxLen]; //index for predecessor of element nums[i]
                maxLen++;
                mark[maxLen] = i;
            }
            else {
                /*find in the first element in mark s.t. nums[mark[j]] < nums[i], meaning the IS of length j has ending smaller than nums[i], and IS of length j + 1 or longer has ending larger than nums[i], then the smallest last element of an IS of length j + 1 can be updated to nums[i] */
                int l = 1, r = maxLen;
                int pos = -1;
                //System.out.println("MAXLEN = " + maxLen);
                //finding the first element bigger than nums[i]
                while(l <= r){
                    int mid = l + (r - l) / 2;
                    if (nums[mark[mid]] > nums[i] ) {
                        //if (mid == 1 || nums[i] > nums[mark[mid - 1]]) pos = mid;
                        pos = mid;
                        r = mid - 1;
                    }
                    else l = mid + 1;
                    //System.out.println("l = " + mark[l]  + " r = " + mark[r]);
                }
                System.out.println("nums[i] = " + nums[i] + " pos = " + pos + " i = " + i);
                //p[i] = mark[pos - 1];
                if (pos != -1 && (pos == 1 || nums[i] > nums[mark[pos-1]])) {p[i] = mark[pos - 1]; mark[pos] = i;}
                //if (pos == 1) p[i] == -1;
            }
            for(int k = 1; k <= maxLen; k++){
                System.out.print(nums[mark[k]] + " ");
            }
            System.out.print("-------------");
            
            
        int L = maxLen;
        int idx = mark[L];
        while(idx >= 0){
            System.out.print(nums[idx] + " ");
            idx = p[idx];
        }
        System.out.print("-------------\n");
        //System.out.println("p[1] = " + p[1]);

        //return maxLen;
            
        }
        
        // for(int k = 0; k < nums.length; k++){
        //     System.out.print(p[k] +" ");
        // }
        // System.out.println();
    
        int L = maxLen;
        int idx = mark[L];
        while(idx >= 0){
            System.out.print(nums[idx] + " ");
            idx = p[idx];
        }
        return maxLen;
        
    }
}

//[3,5,6,2,5,4,19,5,6,7,12]
//[10, 9, 2, 5, 3, 7, 101, 18]