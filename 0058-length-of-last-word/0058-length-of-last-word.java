class Solution {
    public int lengthOfLastWord(String s) {
         
         int n = s.length();
         
         int i = n-1;
          
          int count  =0;
          while(i >= 0){
                   
                
               if(Character.isLetter(s.charAt(i))){
                    count++;
               }
               if(count > 0 && s.charAt(i) == ' '){
                    return count;
               }
             i--;
          }

          return count;
    }
}