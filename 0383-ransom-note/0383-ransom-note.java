class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
         
        HashMap<Character,Integer> count = new HashMap<>();

        for(char sp :magazine.toCharArray()){
            count.put(sp,count.getOrDefault(sp,0)+1);
        }

        for(char sp : ransomNote.toCharArray()){
            count.put(sp,count.getOrDefault(sp,0)-1);

            if(count.get(sp) < 0){
               return  false;
            }
        }

        return true;
    }
}