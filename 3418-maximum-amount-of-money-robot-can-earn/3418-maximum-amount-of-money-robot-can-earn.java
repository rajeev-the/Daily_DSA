class Solution {
    int n ;
    int m ;
    Integer[][][] dp;
    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;
         dp = new Integer[m][n][3];
         return solve(0,0,2,coins);

    }
    public int  solve(int i , int j ,int k , int[][] coins){
         
         if(i >= m || j >= n) return Integer.MIN_VALUE;

         if(dp[i][j][k] != null) return dp[i][j][k];

         if(i == m -1 && j == n -1){

            if(coins[i][j] >= 0 ){
                return dp[i][j][k] = coins[i][j];
            }
            else{
                if(k > 0 )return dp[i][j][k]  = 0;
                else return dp[i][j][k] = coins[i][j]; 
            }
         }

         // move forward 

         int down = solve(i+1,j,k,coins);
         int right = solve(i,j+1,k,coins);
         
         int bestnext = Math.max(down,right);


         if(bestnext == Integer.MIN_VALUE){
            return dp[i][j][k] = Integer.MIN_VALUE;
         }

         if(coins[i][j] >= 0){
            return dp[i][j][k] = coins[i][j] + bestnext;
         }

         int takeLoss = coins[i][j] + bestnext;

         int neutrailzed = Integer.MIN_VALUE;

         if(k > 0){
            int  down2 = solve(i+1,j,k-1,coins);
            int  right2 = solve(i,j+1,k-1,coins);
            neutrailzed = Math.max(down2,right2);
         }

         return dp[i][j][k] =  Math.max(neutrailzed,takeLoss);

    }
}