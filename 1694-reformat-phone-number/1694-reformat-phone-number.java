class Solution {
    public String reformatNumber(String number) {
        

        StringBuilder digit = new StringBuilder();

        for(char ch : number.toCharArray()){
             
             if(ch != ' ' && ch != '-'){
                digit.append(ch);
             }
        }

        StringBuilder ans = new StringBuilder();
         
         int n = digit.length();
         int i =0 ;

         while(n-i >4){
             if(ans.length() >0){
                ans.append("-");
             }
             ans.append(digit.substring(i,i+3));
             i+=3;
         }
        
          
          int rem = n-i;

          if(rem == 4){
            if(ans.length()>0){
                ans.append("-");
            }
             ans.append(digit.substring(i,i+2));
             ans.append("-");
             ans.append(digit.substring(i+2,i+4));
          }
          else if(rem >0){
                if(ans.length()>0){
                ans.append("-");
            }
             ans.append(digit.substring(i));

          }



      return ans.toString();
    }
}