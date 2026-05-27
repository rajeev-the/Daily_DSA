class Solution {
    public int getMinSwaps(String num, int k) {
         
         int n = num.length();
        int[] nums = new int[n];
        int[] orginal = new int[n];

        for(int i = 0 ; i < num.length() ; i++){
             nums[i] = num.charAt(i)-'0';
             orginal[i] = num.charAt(i)-'0';
        }
         

         while(k > 0){

        int i = n-2;
        int j = n-1;
        

        while(i >=0 && nums[i] >= nums[i+1] ){
            i--;
        }

        if(i >= 0){
             

             while(j >= 0 && nums[i] >= nums[j] ){
                j--;
             }

             swap(i,j,nums);

        }

        reverse(i+1,nums.length-1,nums);

          k--;
    }
      
      int count = 0;


      for(int i =0 ; i < n ; i++){
          
          if(orginal[i] !=  nums[i]){
               int j = i;


               while(orginal[i] != nums[j]){
                    j++;
               }

               while(j > i){
                  
                  swap(j,j-1,nums);
                  count++;
                  j--;
               }
          }
      }



    return count;
    }
    public void swap(int i , int j , int[] nums){
       int temp = nums[i];
       nums[i] = nums[j];
       nums[j] = temp; 
    }

    public void reverse(int i , int j , int[] nums){
         
         while(i < j){
            swap(i,j,nums);
            i++;
            j--;
         }
    }


}

// we need next permutation of that String 