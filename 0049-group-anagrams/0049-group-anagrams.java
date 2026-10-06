class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> sp = new HashMap<>();

        for(String words : strs){
           
           char[] unsort_word = words.toCharArray();

           Arrays.sort(unsort_word);

           String value = new String(unsort_word);

           if(sp.containsKey(value)){
            sp.get(value).add(words);
           }else{
              sp.put(value,new ArrayList<>());
              sp.get(value).add(words);
           }


        }
       
       List<List<String>> list = new ArrayList<>();


       
       for(String xp : sp.keySet()){
          List<String> values = sp.get(xp); 
        list.add(new ArrayList<>(values));
       }

         return list;
    }
}