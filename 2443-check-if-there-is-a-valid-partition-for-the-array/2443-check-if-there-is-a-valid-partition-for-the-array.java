class Solution {
    public boolean solve(int idx,int[] nums,Boolean[] dp){
        if(idx<0){
            return true;
        }
        if(dp[idx]!=null){
            return dp[idx];
        }
        boolean x=false;
        boolean y=false;
        boolean z=false;
        if(idx>0&&nums[idx]==nums[idx-1]){
            x=solve(idx-2,nums,dp);
        }
        if(idx>1&&nums[idx]==nums[idx-1]&&nums[idx-1]==nums[idx-2]){
            y=solve(idx-3,nums,dp);
        }
        if(idx>1&&nums[idx]==nums[idx-1]+1&&nums[idx-1]==nums[idx-2]+1){
            z=solve(idx-3,nums,dp);
        }
        return dp[idx]=x||y||z;
    }
    public boolean validPartition(int[] nums) {
        int n=nums.length;
        Boolean[] dp=new Boolean[n];
        return solve(n-1,nums,dp);
    }
}