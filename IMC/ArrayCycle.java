public class ArrayCycle{
	private  static int [] A = {1,2,3,4,1};
	private static int [] B= {2,3,1,1,3};
	private static int [] C = {};
	private static int [] D = {1,2,3,4,5,6,6,7,};
	public static void main(String[] agrs){
		//System.out.println("hello world");
		System.out.println(Solution(D));
	}
	public static int Solution(int[] A) {
		if(A == null || A.length == 0){
			return 0;
		}

		if(A.length == 1 || A[0] == 0){
			return 1;
		}

		int nextPosition = 0;
		while(A[nextPosition] > 0){
			int i = nextPosition;
			nextPosition = A[i];
			A[i] *= -1;
		}

		// A[nextPosition] is the starting point of the cycle. Find the length of cycle.
		int cycleStartingPoint = A[nextPosition];
		int step = 1;
		while(true) {
            nextPosition = A[nextPosition] * (-1);
            if (cycleStartingPoint == A[nextPosition])
            	return step; 
            else  step += 1;

		}
		//return -1;
	}
}