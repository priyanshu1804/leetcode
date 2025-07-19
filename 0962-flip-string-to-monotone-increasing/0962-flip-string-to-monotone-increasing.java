class Solution {
    public int minFlipsMonoIncr(String s) {
        int n=s.length();
        int one=0;
        int ans=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                one++;
            }else{
                ans=Math.min(one,ans+1);
            }
        }
        return ans;
    }
}