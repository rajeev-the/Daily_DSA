class Solution {
    int m;
    int n;
    public int[][] findFarmland(int[][] land) {
        m = land.length;
        n = land[0].length;

        List<int[]> res = new ArrayList<>();

        for(int i =0 ; i < m ; i++){
            for(int j =0 ; j < n ; j++){
                 if(land[i][j] == 1){
                    int[] temp = new int[]{i,j,i,j};
                    dfs(land,i,j,temp);

                    res.add(temp);
                 }
            }
        }

        return res.toArray(new int[res.size()][]);

    }
    public void dfs(int[][] land , int i , int j , int[] res){
         
         if(i >= m || j >= n || i <0 || j <0 || land[i][j] == 0){
            return ;
         }

         land[i][j] = 0;

         res[2] = Math.max(i,res[2]);
         res[3] =Math.max(j,res[3]);

         dfs(land,i+1,j,res);
         dfs(land,i-1,j,res);
         dfs(land,i,j-1,res);
         dfs(land,i,j+1,res);
    }
}