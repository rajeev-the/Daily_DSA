class Solution {
    public int minimumPrefixLength(int[] nums) {
        
        int count = 0;

        int left = 0;
        int right = nums.length -2;

        while(left <= right){
             
             if(nums[right] < nums[right+1]){
                 right--;
                continue;
             }
             else{
                return right+1;
             }
             
        }

          return 0;
    }
}