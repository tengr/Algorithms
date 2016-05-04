package InterviewBitJava;

import java.util.Arrays;

public class ArrangeHorse {
	
	public static void main(String[] args){
		ArrangeHorse ins = new ArrangeHorse();
		ins.util("WWWB");
	}
	
	public void util(String a) {
        int[] countW = new int[a.length() + 1], countB = new int[a.length() + 1];
        int[][] table = new int[a.length() + 1][a.length() + 1];
        for(int i = 1; i <= a.length(); i++) {
            if(a.charAt(i - 1) == 'W') {
                countW[i] = countW[i-1] + 1;
            }
            else countB[i] = countB[i-1] + 1;
        }
        
        for(int i = 0; i < a.length(); i++){
        	for(int j = i + 1; j <= a.length(); j++)
        		table[i][j] = (countW[j] - countW[i + 1]) * (countB[j] - countB[i + 1]);
        }
//        
        System.out.println(Arrays.toString(countW));
        System.out.println(Arrays.toString(countB));
        
        System.out.println(table[0][4]);
        
	}
	
	
	public int arrange(String a, int b) {
        
        
		return 0;
	}
	
	
        
}
