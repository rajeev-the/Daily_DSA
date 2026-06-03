class Solution {
    public String decodeString(String s) {
         
         Stack<Integer> num = new Satck<>();

         Stack<StringBuilder> str = Stack<>();

         StringBuilder sb = new StringBuilder();

         int n = 0

         for(char a : s.toCharArray()){
              
              if(Character.digit(a)){
                 n = n*10 + (a-'0');

              }
              else if(a == '['){
                num.offer(n);
                n =0;
                str.offer(sub);
                sb = new  StringBuilder();
              }
              else if( a ==']'){
                  int t = num.pop();
                
                  while(t-- >0 ){
                    sb.append(str.pop);
                  }
              }
              else{
                sb.append(a);
              }
         }
    }
}