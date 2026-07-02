class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
          
            Arrays.sort(occupiedIntervals, (a,b)-> Integer.compare(a[0], b[0]));
           List<List<Integer>> res =  new ArrayList<>();

        int n = occupiedIntervals.length;
           merge(res,occupiedIntervals,n);
            

           List<List<Integer>> ans = new ArrayList<>();

for (List<Integer> sp : res) {

    int start = sp.get(0);
    int end = sp.get(1);

    // Occupied interval completely removed
    if (start >= freeStart && end <= freeEnd) {
        continue;
    }

    // Free interval is inside occupied interval (split)
    else if (start < freeStart && end > freeEnd) {
        ans.add(new ArrayList<>(Arrays.asList(start, freeStart - 1)));
        ans.add(new ArrayList<>(Arrays.asList(freeEnd + 1, end)));
    }

    // Overlap on the right
    else if (start < freeStart && end >= freeStart) {
        ans.add(new ArrayList<>(Arrays.asList(start, freeStart - 1)));
    }

    // Overlap on the left
    else if (start <= freeEnd && end > freeEnd) {
        ans.add(new ArrayList<>(Arrays.asList(freeEnd + 1, end)));
    }

    // No overlap
    else {
        ans.add(new ArrayList<>(Arrays.asList(start, end)));
    }
}

return ans;

       
    }

    public void merge(List<List<Integer>> res , int[][] occupiedIntervals , int n ){
         
         int start = occupiedIntervals[0][0];
         int end = occupiedIntervals[0][1];
           
           for(int i =0 ; i < n ; i++){

                 if(occupiedIntervals[i][0] <= end +1 ){
                    end = Math.max(end , occupiedIntervals[i][1]);
                 }else{
                    res.add(new ArrayList<>(Arrays.asList(start,end)));
                    start = occupiedIntervals[i][0];
                    end = occupiedIntervals[i][1];
                 }

           } 

           res.add(new ArrayList<>(Arrays.asList(start, end)));

    }
    public void wrong_merge(List<List<Integer>> res , int[][] occupiedIntervals , int n ){
                  int i =0;

           while(i < n){

               int[] curr = occupiedIntervals[i];

               if(i+1 < n){      
               int[] next = occupiedIntervals[i+1];
               List<Integer> temp =  new ArrayList<>();

               if(curr[1] >= next[0]){
                temp.add(curr[0]);
                temp.add(next[1]);
                   i+=2;
               }
               else{
                 
                temp.add(curr[0]);
                temp.add(curr[1]);
                   i++;
               }
               res.add(new ArrayList<>(temp));

               }


               else{
                    List<Integer> temp =  new ArrayList<>();
                     temp.add(curr[0]);
                     temp.add(curr[1]);
                    res.add(new ArrayList<>(temp));
                    i++;
               }
              
           }
    }
}