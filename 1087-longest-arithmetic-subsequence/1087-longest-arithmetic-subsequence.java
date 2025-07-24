class Solution {
    public int solve(int idx,int diff,Integer[][] dp,int[] nums,int n){
        if(idx==n){
            return 0;
        }
        if(dp[idx][diff+501]!=null){
            return dp[idx][diff+501];
        }
        int ans=0;
        if(diff==-501){
            for(int i=idx+1;i<n;i++){
                int take=1+solve(i,nums[i]-nums[idx],dp,nums,n);
                int nottake=solve(i,diff,dp,nums,n);
                ans=Math.max(ans,Math.max(take,nottake));
            }
        }else{
            for(int i=idx+1;i<n;i++){
                int take=0;
                if(diff==nums[i]-nums[idx]){
                    take=1+solve(i,nums[i]-nums[idx],dp,nums,n);
                }
                ans=Math.max(ans,take);
            }
        }
        return dp[idx][diff+501]=ans;
    }
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        Integer[][] dp=new Integer[n][1002];
        return solve(0,-501,dp,nums,n)+1;
    }
}