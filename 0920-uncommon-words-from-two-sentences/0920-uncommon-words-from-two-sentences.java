class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] words1=s1.split(" ");
        String[] words2=s2.split(" ");
        HashMap<String,Integer> map=new HashMap<>();
        for(String word:words1){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for(String word:words2){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        ArrayList<String> ans=new ArrayList<>();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()==1) {
                ans.add(entry.getKey());
            }
        }
        return ans.toArray(new String[0]);
    }
}