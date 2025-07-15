class Solution {
    public boolean solve1(String s,int start,int end,Boolean[][] dp){
        if(start>=end){
            return true;
        }
        if(dp[start][end]!=null){
            return dp[start][end];
        }
        return dp[start][end]=s.charAt(start)==s.charAt(end)&&solve1(s,start+1,end-1,dp);
    }
    public boolean solve(String s,Boolean[][] dp){
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n-1;j++){
                if(solve1(s,0,i,dp)&&solve1(s,i+1,j,dp)&&solve1(s,j+1,n-1,dp)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkPartitioning(String s) {
        Boolean[][] dp=new Boolean[s.length()][s.length()];
        return solve(s,dp);
    }
}