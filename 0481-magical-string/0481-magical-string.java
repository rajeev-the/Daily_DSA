class Solution {
    public int magicalString(int n) {
        
        StringBuilder str = new StringBuilder("122");
        
        int i =0;
        int head = 2;

        int num = 1;

        while(head < n){
            
            char next = str.charAt(head);
            
            int j =0;
            while( j < next - '0'){
                str.append(num);
                j++;
            }

            num = 3- num;
            head++;
        }


    
       int count = 0;
       for(int k = 0 ; k < n ; k++){
            
            if(str.charAt(k) =='1'){
                count++;
            }
       }
 
     return count;


    }
}

