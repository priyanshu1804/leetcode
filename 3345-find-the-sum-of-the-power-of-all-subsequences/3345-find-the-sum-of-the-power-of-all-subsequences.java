class Solution {
    int mod=(int)1e9+7;
    public long solve(int[] nums,int i,int sum,int[][] dp){
        if(sum<0){
            return 0;
        }
        if(i==nums.length){
            return sum==0?1:0;
        }
        if(dp[i][sum]!=-1){
            return dp[i][sum];
        }
        long notpick=(solve(nums,i+1,sum,dp)*2L)%mod;
        long pick=solve(nums,i+1,sum-nums[i],dp);
        long ans=(pick+notpick)%mod;
        return dp[i][sum]=(int)ans;
    }
    public int sumOfPower(int[] nums, int k) {
        int n=nums.length;
        int[][] dp=new int[n][k+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return (int)solve(nums,0,k,dp);
    }
}