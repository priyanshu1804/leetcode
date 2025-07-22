class Solution{
    public int longestContinuousSubstring(String s){
        int count=1;
        int n=s.length();
        int ans=1;
        for(int i=1;i<n;i++){
            if(s.charAt(i)-s.charAt(i-1)==1){
                count++;
            }else{
                count=1;
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}
