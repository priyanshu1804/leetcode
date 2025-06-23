class Solution {
    public long solve(int start,int end,int k,long[] preNums,long[] preCost,Long[][] dp){
        int n=preNums.length;
        if(end==n){
            if(start==n){
                return 0;
            }
            return Long.MAX_VALUE;
        }
        if(dp[start][end]!=null){
            return dp[start][end];
        }
        long curr=preNums[end];
        long cost=preCost[n-1];
        if(start!=0){
            curr=preNums[end]-preNums[start-1];
            cost=preCost[n-1]-preCost[start-1];
        }
        long cost1=(curr+k)*cost;
        long pick=cost1+solve(end+1,end+1,k,preNums,preCost,dp);
        long notpick=solve(start,end+1,k,preNums,preCost,dp);
        return dp[start][end]=Math.min(pick,notpick);
    }
    public long minimumCost(int[] nums, int[] cost, int k) {
        int n=nums.length;
        long[] preNums=new long[n];
        long[] preCost=new long[n];
        preNums[0]=nums[0];
        preCost[0]=cost[0];
        for(int i=1;i<n;i++){
            preNums[i]=preNums[i-1]+nums[i];
            preCost[i]=preCost[i-1]+cost[i];
        }
        Long[][] dp=new Long[n][n];
        long ans=solve(0,0,k,preNums,preCost,dp);
        return ans;
    }
}