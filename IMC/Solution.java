import java.util.Map;
class Solution {
    private static int N;
    private static int M;
    private static int [][]Board;
    private static HashMap<String, Integer> valueMap = new HashMap<String, Integer>();

    public int solution(int[][] A) {
        Board = A;
        N = A.length;
        if (N > 0) {
            M = A[0].length;
        }
        int start_n = 0;
        int start_m = 0;
        traverse(start_n, start_m, start_n, start_m, 0);
        return valueMap.get(String.valueOf(start_n) + "," + String.valueOf(start_m));
    }

    private void traverse(int start_n, int start_m, int current_val) {
        // A valid path has been found before.
        if(valueMap.containsKey(p_to_s(start_n, start_m))) {
            return current_val + valueMap.get(p_to_s(start_n, start_m));
        }        
        if (start_n < N - 1 && start_m < M - 1) {
            int result_a = traverse(start_n + 1, start_m, current_val + Boad[start_n][start_m]); 
            int result_b = traverse(start_n, start_m + 1, current_val + Board[start_n][start_m]);
            int max = Math.max(result_a, result_b);
            if(max > valueMap.get(p_to_s(start_n, start_m))) {
                valueMap.put(p_to_s(start_n, start_m), max);            
            }
            return max;
        } else if (start_m < M - 1) {
            int max = traverse(start_n, start_m + 1, current_val + Board[start_n][start_m]);
            if(max > valueMap.get(p_to_s(start_n, start_m))) {
                valueMap.put(p_to_s(start_n, start_m), max);            
            }
        } else if (start_n < N - 1) {
            int max = traverse(start_n + 1, start_m, current_val + Board[start_n][start_m]);
            if(max > valueMap.get(p_to_s(start_n, start_m))) {
                valueMap.put(p_to_s(start_n, start_m), max);            
            }
        } else {
            return current_val + Board[start_n][start_m];
        }
    }

    private String p_to_s(int x, int y) {
        return String.valueOf(x) + "," + String.valueOf(y);
    }
}