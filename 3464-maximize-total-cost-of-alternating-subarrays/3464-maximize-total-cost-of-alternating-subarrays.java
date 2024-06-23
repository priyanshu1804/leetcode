class Solution {
    public long solve(int[] nums,int idx,int flag,long[][] dp){
        if(idx==nums.length){
            return 0;
        }
        if(dp[idx][flag]!=-1){
            return dp[idx][flag];
        }
        long take=0;
        if(flag==1){
            take=nums[idx]+solve(nums,idx+1,0,dp);
        }else{
            take=-nums[idx]+solve(nums,idx+1,1,dp);
        }
        long nottake=nums[idx]+solve(nums,idx+1,0,dp);
        return dp[idx][flag]=Math.max(take,nottake);
    }
    public long maximumTotalCost(int[] nums) {
        long[][] dp=new long[nums.length+1][2];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return solve(nums,0,1,dp);
    }
}