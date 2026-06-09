class Solution {
     class Pair{
        int index;
        int value;
        public Pair(int index , int value){
            this.index = index;
            this.value = value;
        }
     }
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        
        PriorityQueue<Pair> sp = new PriorityQueue<>(
            (a,b)->{
                if(a.value == b.value){
                    return a.index - b.index;
                }
                return a.value - b.value;
            }
        );

    
        int n = nums.length;
        long sum =0L;

        for(int i =0 ; i <n ; i++){
            Pair temp = new Pair(i,nums[i]);
            sp.offer(temp);
             sum += nums[i];
        }

         

        List<Long> list = new ArrayList<>();


        for(int[] q : queries){
              
              int[] temp = q;

              int index = temp[0];

              if(nums[index] != 0){
                sum = sum -  nums[index];
               
                nums[index] = 0;
              }
            
            int k = temp[1];
            
           
            while(k > 0 && !sp.isEmpty()){
                 Pair number = sp.poll();

                  if(nums[number.index] != 0){
                    sum = sum - number.value;
                    
                     nums[number.index] = 0;
                      k--;
                  }
            }

            list.add(sum);

        }

        long[] ans = new long[list.size()];

        for(int i = 0 ; i <list.size() ; i++){
            ans[i] = list.get(i);
        }

    
   return ans;


    }
}