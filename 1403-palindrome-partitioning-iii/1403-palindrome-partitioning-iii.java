class Solution {
    public int solve(String s,int idx,int k,int[][] dp){
        if(k==0&&idx==s.length()){
            return 0;
        }
        if(k<=0){
            return 1000000;
        }
        if(dp[idx][k]!=-1){
            return dp[idx][k];
        }
        int ans=1000000;
        for(int i=idx;i<s.length();i++){
            int ans1=solve1(s.substring(idx,i+1));
            ans=Math.min(ans,solve(s,i+1,k-1,dp)+ans1);
        }
        return dp[idx][k]=ans;
    }
    public int solve1(String s){
        int i=0;
        int j=s.length()-1;
        int cnt=0;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                cnt++;
            }
            i++;
            j--;
        }
        return cnt;
    }
    public int palindromePartition(String s, int k) {
        int[][] dp=new int[s.length()+1][k+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(s,0,k,dp);
    }
}