class Solution {
    public int solve(int i,int op1,int op2,int n,int[] nums,int k,int[][][] dp){
        if(i==n){
            return 0;
        }
        if(dp[i][op1][op2]!=-1){
            return dp[i][op1][op2];
        }
        int ans=Integer.MAX_VALUE;
        ans=Math.min(ans,solve(i+1,op1,op2,n,nums,k,dp)+nums[i]);
        if(op1>0){
            ans=Math.min(ans,solve(i+1,op1-1,op2,n,nums,k,dp)+((int)Math.round((double)nums[i]/2)));
        }
        if(op2>0&&nums[i]>=k){
            ans=Math.min(ans,solve(i+1,op1,op2-1,n,nums,k,dp)+nums[i]-k);
        }
        if(op1>0&&op2>0&&nums[i]>=k){
            ans=Math.min(ans,solve(i+1,op1-1,op2-1,n,nums,k,dp)+(int)Math.round((double)(nums[i]-k)/2));
        }
        if(op1>0&&op2>0&&((int)Math.round((double)nums[i]/2))>=k){
            ans=Math.min(ans,solve(i+1,op1-1,op2-1,n,nums,k,dp)+((int)Math.round((double)nums[i]/2))-k);
        }
        return dp[i][op1][op2]=ans;
    }
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        int n=nums.length;
        int[][][] dp=new int[n][op1+1][op2+1];
        for(int[][] it:dp){
            for(int[] rows:it){
                Arrays.fill(rows,-1);
            }
        }
        return solve(0,op1,op2,n,nums,k,dp);
    }
}