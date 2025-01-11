class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()==k){
            return true;
        }
        if(k>s.length()){
            return false;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int count=0;
        for(Map.Entry<Character,Integer> it:map.entrySet()){
            if(it.getValue()%2!=0){
                count++;
            }
        }
        if(count<=k){
            return true;
        }
        return false;
    }
}