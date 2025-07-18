class Solution {
    public int solve(int i,int[] stones,int[] dp){
        if(i==0){
            return 0;
        }
        if(i==1){
            return Math.abs(stones[i]-stones[i-1]);
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int curr=Math.abs(stones[i]-stones[i-2]);
        int rem=solve(i-1,stones,dp);
        return dp[i]=Math.max(curr,rem);
    }
    public int maxJump(int[] stones) {
        int n=stones.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,stones,dp);
    }
}