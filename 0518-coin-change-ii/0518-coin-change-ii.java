class Solution {
    public int change(int amount, int[] coins) {
        
        int n = coins.length;


        int[][] dp = new int[n+1][amount+1];

        for(int[] sp : dp){
             Arrays.fill(sp,-1);
        }
       

        return solve(amount,coins, 0,dp);
    }
    public  int solve(int amount , int[] coins , int i , int[][] dp ){
         
         if(i == coins.length ){
            return 0;
         }

         if( amount ==  0){
            return 1;
         }

         if(dp[i][amount] != -1){
            return dp[i][amount];
         }

           
           int take = 0;
         if(amount >= coins[i]){
            take = solve(amount-coins[i] ,coins , i,dp);
         }
         
         int skip = solve(amount , coins ,i+1,dp);

         return  dp[i][amount] = take + skip;
    } 

    
}

/// recursion + loop hoga 