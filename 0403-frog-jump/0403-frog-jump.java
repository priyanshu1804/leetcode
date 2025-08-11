class Solution {
    public boolean solve(int i,int prev,int[] stones,Boolean[][] dp){
        if(i>=stones.length){
            return false;
        }
        if(i==stones.length-1){
            return true;
        }
        if(dp[i][prev]!=null){
            return dp[i][prev];
        }
        int x=stones[i]+prev;
        int idx=Arrays.binarySearch(stones,x);
        if(idx>i){
            boolean x1=solve(idx,prev-1,stones,dp);
            boolean x2=solve(idx,prev,stones,dp);
            boolean x3=solve(idx,prev+1,stones,dp);
            return dp[i][prev]=x1||x2||x3;
        }
        return false;
    }
    public boolean canCross(int[] stones) {
        Boolean[][] dp=new Boolean[stones.length][stones.length+1];
        return solve(0,1,stones,dp);
    }
}