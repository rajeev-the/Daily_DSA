class Solution {
    int m ;
    int n;
    public int countBattleships(char[][] board) {
        
        m = board.length;
        n = board[0].length;

        int count= 0;
        int[] prev = new int[]{-1,-1};

        for(int i =0 ; i < m ; i++){
            for(int j =0 ; j < n ; j++){
  
                if(board[i][j] == 'X' && (i - prev[0] >= 1 || j - prev[1] >= 1)   ){
                     prev[0] = i;
                    prev[1] = j;
                    dfs(board,i,j);
                    count++;
                }
                 
            }
        }

        return count;
    }
    public void dfs(char[][] board , int i , int j ){
          
          if(i >= m || j >= n || i < 0  || j <0 || board[i][j] =='.' ){
                return ;
          }

          board[i][j] = '.';

        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);

    }


}