package LeetCodeJava;
import java.util.*;

public class NQueen {

    public static void main(String[] args) {
    	NQueen ins = new NQueen();
    	ins.printResult(6);
    }
    
    public void printResult(int n) {
    	List<List<String>> res = solveNQueens(n);
    	System.out.println(res.size() + " solutions.");
    	for(List<String> l : res) {
    		for(String s : l) {
    			System.out.println(s);
    		}
    		System.out.println("---------------");
    	}
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(n <= 0) return res;
        int colNum[] = new int[n]; //colnum for colNum[n] = colNum for row[n];
        boolean[] colEmpty = new boolean[n];
        Arrays.fill(colNum, -1);
        Arrays.fill(colEmpty, true);
        solve(0, res, colEmpty, colNum);
        return res;
    }
    
    public void addResult(List<List<String>> res, int[] colNum) {
        ArrayList<String> ret = new ArrayList<String>();
        for(int i = 0; i < colNum.length; i++) {
            char[] aRow = new char[colNum.length];
            for(int j = 0; j < colNum.length; j++) {
                if(colNum[i] == j) aRow[j] = 'Q';
                else aRow[j] = '.';
            }
            ret.add(String.valueOf(aRow));
        }
        res.add(ret);
    }
    
    public void solve(int row, List<List<String>> res, boolean[] colEmpty, int[] colNum){
        if(row >= colNum.length) {
            addResult(res, colNum);
            return;
        }
        for(int j = 0; j < colNum.length; j++) {
            if(colEmpty[j]){
                boolean jPossible = true;//can place at base[row][j]
                for(int dist = 1; ; dist++) {
                    if (!jPossible || (row-dist < 0) || (j + dist >= colNum.length && j - dist < 0)) break;
                    else {
                        jPossible = jPossible && colNum[row - dist] != j + dist;
                        jPossible = jPossible && colNum[row - dist] != j - dist;
                    }
                }
                if(jPossible) {
                    colNum[row] = j;
                    colEmpty[j] = false;
                    solve(row + 1, res, colEmpty, colNum);
                    colNum[row] = -1;
                    colEmpty[j] = true;
                }
            }
        }
    }
}

