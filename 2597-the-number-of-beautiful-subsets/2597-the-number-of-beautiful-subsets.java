class Solution {
    int count = 0;
    public int beautifulSubsets(int[] nums, int k) {
        
        List<List<Integer>> sp = new ArrayList<>();


            solve(nums,k,0,new ArrayList<>(),sp);

        for(List<Integer> val : sp){
            boolean isvalid = false;
            if(val.size() == 1){
                count++;
            }
            else{

                for(int i =0 ; i < val.size() ; i++){
                for(int j =0 ; j <  val.size() ; j++){

                      if(i == j) continue;

                      if(Math.abs( val.get(i) - val.get(j)) == k ){
                        isvalid = true;
                        break;
                      } 
                  }
                }

                if(!isvalid){
                    count++;
                }

            }
        }

        return count-1;

    }
    public void solve(int[] nums , int k , int index, List<Integer> curr ,  List<List<Integer>> sp){
          
          sp.add(new ArrayList<>(curr));
          for(int i =index; i < nums.length ; i++){   
            curr.add(nums[i]);
            
            solve(nums,k,i+1 ,curr,sp);
            curr.remove(curr.size()-1);
          }

    }
}