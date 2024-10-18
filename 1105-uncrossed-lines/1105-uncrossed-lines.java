class Solution {
    public int solve(int i,int j,int[] nums1,int[] nums2,int[][] dp){
        if(i<=0||j<=0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(nums1[i-1]==nums2[j-1]){
            return dp[i][j]=1+solve(i-1,j-1,nums1,nums2,dp);
        }else{
            return dp[i][j]=Math.max(solve(i-1,j,nums1,nums2,dp),solve(i,j-1,nums1,nums2,dp));
        }
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[][] dp=new int[n1+1][n2+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(n1,n2,nums1,nums2,dp);
    }
}