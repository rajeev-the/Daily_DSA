class Solution {
   
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> list = new HashMap<>();
         

         for(int i : nums){      
          list.put(i , list.getOrDefault(i,0)+1);
         }
            

            int[] res = new int[k];


            int[][] top = new int[list.size()][2];
            int j =0 ;


            for(int sp : list.keySet()){
                 
                 top[j][0]= sp;
                 top[j][1]= list.get(sp);
                 j++;
            }

             
             Arrays.sort(top,(a,b)->b[1]-a[1]);


             for(int i =0 ; i < k ; i++){
                res[i]= top[i][0];
             }
      
       return res;
    }
}

// 1--> 3
// 2-->2
// 3-->1
//