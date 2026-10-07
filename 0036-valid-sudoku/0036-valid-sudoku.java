class Solution {
    public boolean isValidSudoku(char[][] board) {

            int  m = board.length;
           int n = board[0].length;

        // row 
       for(int i =0 ; i < 9 ; i++){
        for(int j = 0 ; j < 9 ; j++){
              
              if(board[i][j] != '.' && !vaild(i,j,board)){
                return false;
              }
        }
       }


       return true; 

        
        
    }
    public boolean vaild(int i , int j , char[][] board ){
           
           // row 
           for(int col = 0 ; col < 9 ;col++){
             if(board[i][col] == board[i][j] && j!=col){
                return false;
             }
           }

           // col

           for(int  row = 0 ; row < 9 ; row++){
                
                if(board[row][j] == board[i][j] && row !=i){
                    return false;
                }
           }
              
              // box of the 

              int new_row = (i/3)*3;
              int new_col = (j/3)*3;


              for(int row = new_row ;  row < new_row+3 ; row++){
                  for(int col = new_col ; col < new_col+3 ; col++){
                              
                   if(board[row][col] == board[i][j] && !( row == i && col  == j )){
                        return false;
                   }
                  }
              }




       return true;
    }
}