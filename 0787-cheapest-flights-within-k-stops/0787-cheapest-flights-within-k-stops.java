class Solution {
    class Pair{
        int node;
        int cost;
        int stop;

        Pair(int node , int cost , int stop){
            this.node = node;
            this.cost = cost;
            this.stop = stop;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         
         List<List<int[]>> adj = new ArrayList<>();

         for(int i =0 ; i < n ; i++){
            adj.add(new ArrayList<>());
         }

         for(int i =0 ; i < flights.length ; i++){
               int start = flights[i][0];
               int end = flights[i][1];
               int w = flights[i][2];
               adj.get(start).add(new int[]{end,w});
         }

         Queue<Pair> q = new LinkedList<>();

         int[] dist = new int[n];
        
        Arrays.fill(dist,Integer.MAX_VALUE);

         q.offer(new Pair(src,0,0));
         dist[src] = 0;

         while(!q.isEmpty()){
               
               Pair  value = q.poll();
               
               int node = value.node;
               int cost = value.cost;
               int stop = value.stop;

               if(stop > k) continue;

               for(int[] edge : adj.get(node)){
                   
                   int next = edge[0];
                   int price = edge[1];

                   if(cost +price < dist[next] && stop <= k){
                        dist[next] = cost +price;
                        q.offer(new Pair(next,dist[next],stop+1));
                   }
               }


         }

         return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }
}