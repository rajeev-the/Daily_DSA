class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
       boolean hasx = false;
       boolean hasy = false;
       boolean hasz = false;

       for(int[] t :triplets ){
           
           if(t[0]> target[0] || t[1] > target[1]  || t[2] > target[2]){
            continue;
           }

           if(t[0] == target[0]) hasx = true;
           if(t[1] == target[1]) hasy = true;
           if(t[2] == target[2]) hasz = true;

       } 


       return hasx && hasy && hasz;
    }
}