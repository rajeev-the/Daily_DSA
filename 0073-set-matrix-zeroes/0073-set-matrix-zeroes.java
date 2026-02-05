class Solution {
    public void setZeroes(int[][] matrix) {

     
        
        List<int[]> res = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;

        for(int i =0 ;i < row ;i++){
            for(int j = 0 ;j < col ;j++){
                if(matrix[i][j] == 0){
                    res.add(new int[]{i,j});
                }
            }
        }

        int size = res.size();
        int indx =0 ;

        while(size > indx ){

            int[] temp = res.get(indx);
            int Row = temp[0];
            int Col = temp[1];

            for(int i = 0 ; i < row ;i++){
                matrix[i][Col] = 0;
            }
            for(int j = 0 ; j < col ; j++){
                 matrix[Row][j] = 0;
            }
            indx++;
            
        }


     
    }
}