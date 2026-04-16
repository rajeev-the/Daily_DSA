class Solution {
    public int[] getOrder(int[][] tasks) {

         int n =  tasks.length;

         int[][] arr = new int[n][3];

         for(int i = 0 ; i < n ; i++){
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
         }

         Arrays.sort(arr,(a,b)->a[0]-b[0]);

        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a,b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
          

        int[] res =  new int[n];  

            int time = 0 ;
            int index =0;
            int i = 0;


            while(index  < n || !q.isEmpty()){
                  
                  if(q.isEmpty() && time  < arr[index][0]){
                        time = arr[index][0];
                  }

                  while(index < n && arr[index][0] <= time){
                    q.offer(arr[index]);
                    index++;
                  }

                  int[] curr = q.poll();
                  res[i++] = curr[2];
                  time +=curr[1]; 
            }


            return res;
    }
}