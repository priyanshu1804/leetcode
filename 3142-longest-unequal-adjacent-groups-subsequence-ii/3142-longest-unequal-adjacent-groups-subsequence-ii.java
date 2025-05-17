class Solution {
    public List<String> solve(int idx,int prev,String[] words,int[] groups,HashMap<String,List<String>> map){
        if(idx>=words.length){
            return new ArrayList<>();
        }
        String key=idx+" "+prev;
        if(map.containsKey(key)){
            return map.get(key);
        }
        List<String> pick=new ArrayList<>();
        if(prev==-1||((groups[prev]!=groups[idx])&&(words[prev].length()==words[idx].length())&&solve1(words[prev],words[idx])==1)){
            pick=new ArrayList<>(solve(idx+1,idx,words,groups,map));
            pick.add(0,words[idx]);
        }
        List<String> notpick=solve(ind+1,prev,words,groups,map);
        if(notpick.size()>pick.size()){
            map.put(key,notpick);
        }else{
            map.put(key,pick);
        }
        return map.get(key);
    }
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
       HashMap<String,List<String>> map=new HashMap<>();
       List<String> ans=solve(0,-1,words,groups,map);
       return ans; 
    }
}