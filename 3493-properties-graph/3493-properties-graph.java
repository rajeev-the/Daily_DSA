class Solution {
    public int numberOfComponents(int[][] properties, int k) {

        int n = properties.length;
         
         List<List<Integer>> graph = new ArrayList<>();

         for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
         }

         for(int i =0 ; i <  n ; i++){
            for(int j = i +1 ; j < n ; j++){
                  
                  if(intersect(properties[i],properties[j]) >= k ){
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                  }
            }
         }

         boolean[] visited = new boolean[n];
         int components = 0;

         for(int i =0 ; i  < n ; i++){
               if(!visited[i]){
                dfs(i,graph,visited);
                components++;
               }
         }
         
         return components;
        
    }
    
    public void dfs(int node , List<List<Integer>> graph ,  boolean[] vis){
          vis[node]=  true;
            
            for(int nei : graph.get(node)){
                if(!vis[nei]){
                    dfs(nei,graph,vis);
                }
            }
    }

    public Integer intersect(int[] a , int[] b){
           
           Set<Integer> setA = new HashSet<>();
           Set<Integer> commom = new HashSet<>();

           for(int val : a) setA.add(val);

           for(int val : b){
               
               if(setA.contains(val)){
                commom.add(val);
               }
           }

           return commom.size();
    }
}