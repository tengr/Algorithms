package InterviewBitJava;

import java.util.Arrays;
import java.util.List;

public class CanCompleteCircuit {
	public static void main(String[] args){
		CanCompleteCircuit ins = new CanCompleteCircuit();

		System.out.println(ins.canCompleteCircuit(Arrays.asList(684,57,602, 987), Arrays.asList(909, 535, 190, 976)));
	}
	public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
	    int n = gas.size();
	    for(int start = 0, end = 0, sum = 0; ;) {
    	    if(sum >= 0) {
    	        sum += (gas.get(end) - cost.get(end));
    	        end = (end + 1) % n;
    	        System.out.println("start = " + start + " end = " + end + " sum = " + sum);
    	        if (end == start && sum >= 0) return start;
    	    }
    	    else {
    	        while(sum < 0) {
    	            sum -= (gas.get(start) - cost.get(start));
    	            start++;
    	            if (start > n - 1) return -1;
    	            else if(start > end) {
    	                end = start;
    	                break;
    	            }
    	        }
    	        
    	        
    	    }
    	    
	    }
    }
}
