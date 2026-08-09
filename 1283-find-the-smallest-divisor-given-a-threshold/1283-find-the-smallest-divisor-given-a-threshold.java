class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int low = 1;
        int high = Integer.MIN_VALUE;

        for(int i : nums){
            high = Math.max(i,high);
        }
        int ans = high;

        while(low <= high){
             
             int mid = low+(high-low)/2;
              
              if(isdivisible(mid,nums,threshold)){
                    ans = mid;
                    high = mid-1;
              }
              else{
                   low = mid+1;
              }
        }

        return ans;
    }
    public boolean isdivisible(int mid , int[] nums , int threshold){
         
         int count = 0;

         for(int i = 0 ; i < nums.length ; i++){
                count += (nums[i] + mid-1) /mid;
 
                if(count > threshold) return false;
         }

          return true;
    }
}