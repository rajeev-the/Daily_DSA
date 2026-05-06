class Solution {
    int m ;
    int n ;
    char[][] new_box;
    public char[][] rotateTheBox(char[][] boxGrid) {
        m = boxGrid.length;
        n = boxGrid[0].length;
        
        new_box = new char[n][m];
        // boolean[][]  vis = new 
         

        for(int i =0 ; i < m ; i++){
             for(int j = 0 ; j < n ; j++){
                 new_box[j][i] = boxGrid[i][j];
             }
        }


        for(int i =0 ; i < n ; i++){
             
             int left = 0;
             int right = m -1;

             while(left < right){
                 
                 char temp =  new_box[i][left];
                 new_box[i][left] = new_box[i][right];
                 new_box[i][right] = temp;

                 left++;
                 right--;
             }
        }

        for(int j =0 ; j < m ; j++){
            for(int i = n-1 ; i >= 0 ; i--){
                 
                 if(new_box[i][j] == '#'){
                    solve(i,j);
                 }
            }
        }


     return new_box;

    }
    public void solve(int i , int j ){

       while (i + 1 < n &&
               new_box[i + 1][j] == '.') {

            new_box[i + 1][j] = '#';
            new_box[i][j] = '.';

            i++;
        }
    }


}

// think about only just rotation of the grid --> 90* degree of it