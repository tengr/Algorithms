
public class BinSearchDoesThisWork {
	
	public static void main(String[] args) {
		System.out.println(binarySearch(new int[]{1,2,3,4,5}, 6 ));
	}
	 public static int binarySearch(int[] sum, int b){
         
	      int start =0;
	      int end = sum.length - 1;
	      //int res=-1;
	       	  
	      while(start < end){
	         if(sum[(end - start)/2] > b)
	            end = (end - start)/2;
	         else //sum[index/2] < b
	         {
	            start = (end - start)/2;            
	         }
	         System.out.println("start = " + start + " end = " + end + " mid = " + sum[(end - start)/2]);
	      }
	      
	      return start;
	      
	}
}
