class Solution {
    public int shipWithinDays(int[] weights, int days) {

            int low = 0;
            int high = 0;

            for(int i : weights){
              low =  Math.max(low,i);
              high+=i;
            }

             low = low -1;

            while(low+1 < high){
                int mid = low + (high-low)/2;

                if(ispossible(mid,days,weights)){
                    high = mid;
                }
                else{
                    low = mid;
                }
            }

            return high;
    }
    public boolean ispossible(int mid , int days ,int[] weights){
             
             int count = 1;

             int currweight = 0;


             for(int i : weights){
                 
                  if(currweight+i <= mid){
                     currweight+=i;
                  }
                  else{
                    count++;
                    currweight = i;
                  }
             }
           
         return  count <= days;
    }
}