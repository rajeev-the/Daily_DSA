class Solution {
    public boolean isValid(String s) {
        Stack<Character> sp = new Stack<>();

        for(char letter : s.toCharArray()){
            
            if(letter == '(' || letter == '{' || letter == '['){
                sp.push(letter);
            }
            else{
                if(sp.isEmpty()) return false;

                char top = sp.pop();

                if(letter == ')' && top != '(' ) return false;
                if(letter == '}' && top != '{' ) return false;
                if(letter == ']' && top != '[' ) return false;

            }

          

        }
          return sp.isEmpty();
    }
}