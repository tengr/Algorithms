package programming.graphs.smallest.sequence.with.given.primes;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
	public static void main(String[] args) {
		Solution solution = new Solution();
		//System.out.println(solution.solve(2,3,5,30));
		solution.solve(2,3,5,30);
	}
	public ArrayList<Integer> solve(int p1,int p2,int p3,int k)
	{
		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
		int[] nextBestNumbers = new int[3];
		int[] currIndex = new int[3];
		int[] prime = new int[3];

		nextBestNumbers[0] = prime[0] = p1;
		nextBestNumbers[1] = prime[1] = p2;
		nextBestNumbers[2] = prime[2] = p3;

		currIndex[0] = currIndex[1] = currIndex[2] = -1;

		for(int j=0;j<k;j++)
		{
			int nextNumber = Math.min(nextBestNumbers[0],Math.min(nextBestNumbers[1],nextBestNumbers[2]));
			finalAnswer.add(nextNumber);

			for(int i=0;i<3;i++)
			{
				if(nextNumber==nextBestNumbers[i])
				{
					currIndex[i]++;
					nextBestNumbers[i] = finalAnswer.get(currIndex[i])*prime[i];
				}
			}
			System.out.println("best numbers = " + Arrays.toString(nextBestNumbers));
			System.out.println("index =  " + Arrays.toString(currIndex));
			System.out.println("result = " + finalAnswer);
		}

		return finalAnswer;
	}
}