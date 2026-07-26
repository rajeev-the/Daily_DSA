class Solution {
    public long numberOfWays(String s) {
           
             long ans =0;
              
            long leftzero = 0;
            long rightzero = 0;
            long leftone = 0;
            long rightone = 0;


           for(char c : s.toCharArray()){
                  
                  if(c == '0'){
                    rightzero++;
                  }
                  else{
                    rightone++;
                  }
           }  


           for(char c : s.toCharArray()){
                 
                 if(c == '0'){
                    rightzero--;
                 }
                 else{
                    rightone--;
                 }

                 if(c == '0'){
                    ans += rightone*leftone;
                 }
                 else{
                    ans += leftzero*rightzero ;
                 }

                 if(c == '0'){
                    leftzero++;
                 }
                 else{
                    leftone++;
                 }



           }  


           return ans;

    }
}