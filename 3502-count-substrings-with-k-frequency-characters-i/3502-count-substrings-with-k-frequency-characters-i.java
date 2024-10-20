class Solution {
    public int numberOfSubstrings(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int i=0;
        int ans=0;
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch)==k){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
                i++;
            }
            ans+=i;
        }
        return ans;
    }
}