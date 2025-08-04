class Solution {
    Integer[][] dp;
    public int solve(int[] nums,int i,boolean flag){
        int n=nums.length;
        if(i==n-1){
            return 1;
        }
        if(dp[i][flag?1:0]!=null){
            return dp[i][flag?1:0];
        }
        int ans=0;
        if(flag){
            if(nums[i+1]>nums[i]){
                ans=Math.max(ans,1+solve(nums,i+1,false));
            }
            else{
                ans=Math.max(ans,solve(nums,i+1,true));
            }
        }else{
            if(nums[i+1]<nums[i]){
                ans=Math.max(ans,1+solve(nums,i+1,true));
            }
            else{
                ans=Math.max(ans,solve(nums,i+1,false));
            }
        }
        return dp[i][flag?1:0]=ans;
    }
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        dp=new Integer[n][2];
        int ans=solve(nums,0,true);
        dp=new Integer[n][2];
        ans=Math.max(ans,solve(nums,0,false));
        return ans;
    }
}