class Solution {
    int m ;
    int n;
    public boolean isValidSudoku(char[][] board) {

         m = board.length;
         n = board[0].length;

        // row 
       for(int i =0 ; i < n ; i++){
        for(int j = 0 ; j < m ; j++){
              
              if(board[i][j] != '.' && !vaild(i,j,board)){
                return false;
              }
        }
       }


       return true;  
    }

    public boolean vaild(int i , int j ,char[][] board){
             
             // row explore
             for(int col =0 ; col < 9 ; col++){
                if(board[i][j] ==  board[i][col] && col !=j  ){
                    return false;
                }
             }

              // col expolre
             for(int row =0 ; row < 9 ; row++){
                if(board[i][j] ==  board[row][j] && row !=i ){
                    return false;
                }
             }

             //explore that specific 3*3 matrix of it 

             int new_row = (i/3)*3;
             int new_col = (j/3)*3;

             for(int row = new_row ; row < new_row+3 ; row++){
                for(int col = new_col ; col < new_col+3 ; col++){
                       
                if((col != j || row != i )&& board[i][j] == board[row][col]){
                    return false;
                }

                }
             }


             return true;
    }

}

// board[i][j] ---> for row and col aya nahi hona chahiya \
// board[i][j] ---> its not present in the it 3*3 matrix also 