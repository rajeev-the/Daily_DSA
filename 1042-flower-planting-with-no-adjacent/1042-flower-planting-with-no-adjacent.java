class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {

        // List<List<Integer>> adj = new ArrayList<>();

        // for(int i =0 ; i < n ; i++){
        //     adj.add(new ArrayList<>());
        // }

        // for(int[] val : paths){
        //       int postion = val[0]-1;
        //       int value = val[1]-1;
        //       adj.get(postion).add(value);
        // }

        // boolean[] vis  = new boolean[n];
        // Queue<Integer> q = new LinkedList<>();

        // int[] res = new int[n];

        // vis[0]=true;
        // int start = 0;
        // q.offer(1);
    
        // while(!q.isEmpty()){
             
        //      int node = q.poll();
              
        //       for(int neigbour : adj.get(node)){
                   
        //            if(!vis[neigbour]){
        //             vis[neigbour] = true;
        //             q.offer(neigbour);
        //            } 
        //       }
             
        //      for(int i =0 ; i < n ; i++){    
        //             if(!vis[i]){
        //                 res[start++] = i+1;
        //                 break;
        //             }
        //      }

        // }


        return solve(n,paths);
    }
    public int[] solve(int n, int[][] paths){


        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] val : paths){
              int postion = val[0]-1;
              int value = val[1]-1;
              adj.get(postion).add(value);
              adj.get(value).add(postion);
        }

        int[] res = new int[n];
         
         for(int i =0 ; i < n ; i++){
              
              boolean[] used = new boolean[5];

                for(int neigbour : adj.get(i)){
                    used[res[neigbour]] = true;
                }  


                for(int color = 1 ; color <= 4 ; color++){
                         
                         if(!used[color]){
                            res[i] = color;
                            break;
                         }
                }            
             
              
         }
           
           return res;
    }
}
 
// 1 --> 2
// 2--> 3
// 3 -->1

// 1 --> 2 , 3 
// 2 --> 3,4
// 3 --> 4 
// 4 -->1

