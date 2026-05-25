class Solution {
    public void sortColors(int[] nums) {
        
        int zero_count = 0;
        int one_count = 0;
        int two_count = 0;

        for(int i : nums){
            if(0 == i){
                zero_count++;
            }
            else if(1 == i){
                one_count++;
            }
            else{
                two_count++;
            }
        }

        int index = 0;

        while(zero_count >0){
            nums[index++] = 0;
            zero_count--;
        }
        while(one_count >0){
            nums[index++] = 1;
            one_count--;
        }
        while(two_count >0){
            nums[index++] = 2;
            two_count--;
        }

        
    }
}

// 0--> red
// 1 --> white
// 2 --> blue
/// mujhe sort with out using any lib. --> 0 ,1,2