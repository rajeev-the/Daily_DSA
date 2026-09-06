class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
         
         int n = plants.length ;
         int a = 0;
         int b = n-1;

         int cap_a= capacityA;
         int cap_b = capacityB; 
         int count = 0;

         while( a < b ){
             
             int left = plants[a];
             int right = plants[b];

             if(left > cap_a ){
                cap_a= capacityA;
                count++;
             }
              if(right > cap_b){
                cap_b = capacityB;
                count++;
             }

             cap_a = cap_a-left ;
             cap_b = cap_b-right;
            a++;
            b--;
         }

         if( a== b){
             
             if(Math.max(cap_a,cap_b) < plants[a]){
                count++;
             }

         }

           return count;
    }
}
// left to right --> Alice
// right to left --> bob
// capacityA --> Alice
// capacityB  --> bob 

