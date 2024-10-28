class Solution {
    public int mod=1000000007;
    public int solve(String s,int t,HashMap<String,Integer> map){
        String key=t+":"+s;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int ans=0;
        for(char ch:s.toCharArray()){
            if(ch+t<='z'){
                ans++;
            }else{
                int ds=t-('z'+1-ch);
                ans+=solve("ab",ds,map);
                ans%=mod;
            }
        }
        map.put(key,ans%mod);
        return ans;
    }
    public int lengthAfterTransformations(String s, int t) {
        HashMap<String,Integer> map=new HashMap<>();
        return solve(s,t,map)%mod;
    }
}