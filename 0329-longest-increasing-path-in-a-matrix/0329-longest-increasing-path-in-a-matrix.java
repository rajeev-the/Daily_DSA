class Solution {
    int n , m;
    int[][] dp;
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        
        n = matrix.length;
        m = matrix[0].length;

        dp = new int[n][m];

        int max =0 ;

        for(int i =0 ; i < n ; i++){
            for(int j =0 ; j < m ; j++){

                max = Math.max(max,dfs(matrix,i,j));
            }
        }

        return max;

    }
    public int dfs(int[][] arr , int i , int j){
        if(dp[i][j] != 0 ){
            return dp[i][j];
        }

        int max = 1;

        for(int[] d :dir ){

            int ni = i+d[0];
            int nj = j+d[1];

           if(ni >=0 && ni < n && nj >=0 && nj < m 
    && arr[ni][nj] > arr[i][j]){
                max = Math.max(max,dfs(arr,ni,nj)+1);
            }
        }

        dp[i][j] = max;
        return max;
    }
}