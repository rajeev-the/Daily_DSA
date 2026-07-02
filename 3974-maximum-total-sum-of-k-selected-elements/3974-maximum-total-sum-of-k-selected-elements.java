class Solution {
    public long maxSum(int[] nums, int k, int mul) {

        Arrays.sort(nums);

        long sum = 0;

        int j = nums.length -1;

        while( j >= 0 && k > 0){

           if(mul > 0) sum += (long) nums[j]*mul;
           else sum += nums[j] ;
            mul--;
            j--;
            k--;
        }

          return sum;       
    }
}