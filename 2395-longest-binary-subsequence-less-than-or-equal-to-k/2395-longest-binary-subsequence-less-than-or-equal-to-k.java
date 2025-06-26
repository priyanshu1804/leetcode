class Solution {
    public int longestSubsequence(String s, int k) {
        int ans=0;
        int curr=0;
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch=='0'){
                ans++;
            }else if(ans<31&&curr+(1L<<ans)<=k){
                curr+=1L<<ans;
                ans++;
            }
        }
        return ans;
    }
}