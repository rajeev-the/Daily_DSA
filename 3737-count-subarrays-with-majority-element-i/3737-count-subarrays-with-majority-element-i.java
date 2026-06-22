class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        
        int n = nums.length;

        int[] transform = new int[n];
          int[] prefix = new int[n+1];

        for(int i =0 ; i < n ; i++){
            transform[i] = nums[i] == target ? 1 :-1;
        }
         prefix[0] = 0;
         for(int i = 1; i <= n ;i++){
            prefix[i] = transform[i-1] + prefix[i-1];
         }

        int count = 0;

        for(int i =0 ; i <= n ; i++){
             
             for(int j =i+1 ; j <= n ; j++){
                 
                 if(prefix[j] - prefix[i] >0){
                    count++;
                 }
             }
        }
     

    return count;

    }
}