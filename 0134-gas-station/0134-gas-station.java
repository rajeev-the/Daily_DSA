class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int curentgas = 0;
        int totalgas = 0;
        int start = 0;

        for(int i =0 ; i < gas.length ;i++){

             int diff = gas[i] - cost[i];

             totalgas+=diff;
             curentgas +=diff;

             if(curentgas < 0){
                start = i +1;
                curentgas = 0;
             }
        }

        return totalgas >= 0 ? start : -1;
    }
}           