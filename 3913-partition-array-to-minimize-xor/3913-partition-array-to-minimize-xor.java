class Solution {
    public int solve(int idx,int k,int[] nums,int[][] dp,int n){
        if(dp[idx][k]!=-1){
            return dp[idx][k];
        }
        if(k==1){
            int xor=nums[idx];
            for(int j=idx+1;j<n;j++){
                xor^=nums[j];
            }
            return xor;
        }
        int pick=0;
        int min=Integer.MAX_VALUE;
        for(int j=idx;j<=n-k;j++){
            pick^=nums[j];
            int notpick=solve(j+1,k-1,nums,dp,n);
            min=Math.min(min,Math.max(pick,notpick));
        }
        return dp[idx][k]=min;
    }
    public int minXor(int[] nums, int k) {
        int n=nums.length;
        int[][] dp=new int[n+1][k+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,k,nums,dp,n);
    }
}