class Solution {
    public String removeKdigits(String num, int k) {
          
          if(num.length() ==1 && k ==1) return "0";
        StringBuilder sp = new StringBuilder();

        int size  = k;

        int n = num.length();

        char min = num.charAt(0);
         
         Stack<Integer> st = new Stack<>();
        

        for(int i =0 ; i < n ; i++){
            
            while(!st.isEmpty() && st.peek() > num.charAt(i)-'0' && k >0 ){
                st.pop();
                k--;
            }
    
         st.push(num.charAt(i)-'0');

        }  

        while(k>0){
            st.pop();
            k--;
        }

        while(!st.isEmpty()){
            char value = (char) (st.pop() + '0');
            sp.append(value);
        }
        
        int i =0;
        sp.reverse();

        while( i < sp.length() &&  sp.charAt(i) =='0'){
           sp.deleteCharAt(i);
        }

        return sp.toString() == "" ? "0": sp.toString();
    }
}

//