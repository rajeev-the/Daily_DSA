class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length == 1) return 0;

        int n = prices.length;
         
         int[][] dp = new int[n+1][2];
          
          for(int[] sp : dp){
            Arrays.fill(sp,-1);
          }
         
         return solve(0,prices,1,dp);
    }
    public int solve(int i , int[] prices , int isbuy,int[][] dp){
        
        if(i >= prices.length){
            return 0;
        }
        
        if(dp[i][isbuy] != -1){
            return dp[i][isbuy];
        }
        // by the stock

        if(isbuy == 1){
            int take = -prices[i] +solve(i+1,prices,0,dp);
            int skip = solve(i+1,prices,1,dp);
            return dp[i][isbuy] =  Math.max(take ,skip);
        }

        //selling the Product
        else{
            int take = prices[i] + solve(i+2,prices,1,dp);
            int skip = solve(i+1,prices,0,dp);
            return dp[i][isbuy] = Math.max(take,skip);
        }
         
        
    }
}