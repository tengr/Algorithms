public class Solution {
    // boolean [][] visited;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word==null || word.length() ==0) return false;
        for (int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                // this.visited = new boolean[board.length][board[0].length];
                if(dfs(board,word,0,new Location(i,j))) return true;
            }
        }
        return false;
    }
    
   
    
    private boolean dfs(char [] [] board,  String word, int i, Location start){
        if(board[start.row][start.col] == word.charAt(i) && i==word.length()-1) return true;
        else if(i==word.length()-1 || board[start.row][start.col] != word.charAt(i)) return false;
      
       
        ArrayList<Location> adj = getAdjacent(board,start);
        for(Location l : adj){
                char cur = board[start.row][start.col];
                board[start.row][start.col] = (char)-1;
                
                if(dfs(board,word,i+1,l)) return true;
                
                board[start.row][start.col] = cur;
        }
        return false;
        
    }
    
    private ArrayList<Location> getAdjacent(char [][] board, Location start ){
        ArrayList<Location> adj = new ArrayList<Location>();
        for(int i=-1; i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(i*i+j*j==1 && start.row+i>=0 && start.row+i < board.length &&
                    start.col+j>=0 && start.col+j<board[0].length)
                        if(board[start.row+i][start.col+j]!=(char)-1)
                            adj.add(new Location(start.row+i,start.col+j));
            }
        }
        return adj;
    }
    
    
}


class Location{
    public Location(int row, int col){
        this.row = row;
        this.col = col;
    }
    int row;
    int col;
}