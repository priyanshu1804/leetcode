class Solution {
    public int solve1(int i,int j,int[] nums){
        int ans=Integer.MIN_VALUE;
        for(int idx=i;idx<=j;idx++){
            ans=Math.max(ans,nums[idx]);
        }
        return ans;
    }
    public int solve(int i,int j,int[] arr,int[][] dp){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int idx=i;idx<j;idx++){
            min=Math.min(min,(solve1(i,idx,arr)*solve1(idx+1,j,arr))+solve(i,idx,arr,dp)+solve(idx+1,j,arr,dp));
        }
        return dp[i][j]=min;
    }
    public int mctFromLeafValues(int[] arr) {
        int[][] dp=new int[arr.length][arr.length];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,arr.length-1,arr,dp);
    }
}