class Solution {
    public boolean solve(int jug1,int jug2,int jug,int target,Boolean[] dp){
        if(jug<0||jug>jug1+jug2){
            return false;
        }
        if(jug==target){
            return true;
        }
        if(dp[jug]!=null){
            return dp[jug];
        }
        dp[jug]=false;
        if(solve(jug1,jug2,jug+jug1,target,dp)){
            return dp[jug]=true;
        }
        if(solve(jug1,jug2,jug+jug2,target,dp)){
            return dp[jug]=true;
        }
        if(solve(jug1,jug2,jug-jug1,target,dp)){
            return dp[jug]=true;
        }
        if(solve(jug1,jug2,jug-jug2,target,dp)){
            return dp[jug]=true;
        }
        return dp[jug]=false;
    }
    public boolean canMeasureWater(int jug1, int jug2, int target) {
        if(jug1+jug2<target){
            return false;
        }
        Boolean[] dp=new Boolean[jug1+jug2+1];
        return solve(jug1,jug2,0,target,dp);
    }
}