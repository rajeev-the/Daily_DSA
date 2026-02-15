class Solution {
    int[][] dp ;
    public int maxCoins(int[] nums) {
        
        int n = nums.length;

        int[] arr = new int[n+2];
        arr[0]= 1;
        arr[n+1] = 1;

        dp = new int[n+2][n+2];

        for(int[] sp :dp){
            Arrays.fill(sp,-1);
        }

        for(int i =0 ; i < n ; i++ ){
            arr[i+1] = nums[i];
        }
       
       return solve(arr,1,n);
    }
    public int solve(int[] arr , int left , int right){
        if(left > right) return 0;

        int max = 0;

        if(dp[left][right] != -1){
            return dp[left][right];
        }

        for(int i = left ; i <= right ; i++){

            int coins = arr[left-1]*arr[i]*arr[right+1] + solve(arr,left,i-1)
            +solve(arr,i+1,right);

            max = Math.max(max,coins);

        }

        dp[left][right] = max;
        return max;
    }
}