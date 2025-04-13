class Solution {
    public int solve(int i,int j,int[] arr,int sum,Integer[][] dp){
        if(j<=i){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int ans=0;
        if(arr[i]+arr[j]==sum){
            ans=Math.max(ans,1+solve(i+1,j-1,arr,sum,dp));
        }
        if(arr[i]+arr[i+1]==sum){
            ans=Math.max(ans,1+solve(i+2,j,arr,sum,dp));
        }
        if(arr[j-1]+arr[j]==sum){
            ans=Math.max(ans,1+solve(i,j-2,arr,sum,dp));
        }
        dp[i][j]=ans;
        return ans;
    }
    public int maxOperations(int[] nums) {
        int n=nums.length;
        int i=0;
        int j=n-1;
        int sum1=nums[i]+nums[i+1]; 
        int sum2=nums[i]+nums[j];
        int sum3=nums[j-1]+nums[j];
        Integer[][] dp=new Integer[n+1][n+1];
        int ans=solve(i,j,nums,sum1,dp);
        dp=new Integer[n+1][n+1];
        ans=Math.max(ans,solve(i,j,nums,sum2,dp));
        dp=new Integer[n+1][n+1];
        ans=Math.max(ans,solve(i,j,nums,sum3,dp));
        return ans;
    }
}