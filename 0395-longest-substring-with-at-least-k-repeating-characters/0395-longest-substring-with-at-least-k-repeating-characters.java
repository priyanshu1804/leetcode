class Solution {
    public int solve(String s,int k,int unique){
        int ans=0;
        int i=0;
        int j=0;
        int count=0;
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        while(j<n){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            if(map.get(s.charAt(j))==k){
                count++;
            }
            if(map.size()==count){
                ans=Math.max(ans,j-i+1);
            }
            while(map.size()>unique){
                if(map.get(s.charAt(i))==k){
                    count--;
                }
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
                if(map.get(s.charAt(i))==0){
                    map.remove(s.charAt(i));
                }
                i++;
            }
            j++;
        }
        return ans;
    }
    public int longestSubstring(String s, int k) {
        int ans=0;
        for(int i=1;i<=26;i++){
            ans=Math.max(ans,solve(s,k,i));
        }   
        return ans;
    }
}