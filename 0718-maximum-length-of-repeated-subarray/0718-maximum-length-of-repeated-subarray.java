class Solution {
    int ans=0;
    public int solve(int i,int j,int[][] dp,int[] nums1,int[] nums2){
        if(i>=nums1.length||j>=nums2.length){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int pick=0;
        if(nums1[i]==nums2[j]){
            pick=1+solve(i+1,j+1,dp,nums1,nums2);
        }
        solve(i,j+1,dp,nums1,nums2);
        solve(i+1,j,dp,nums1,nums2);
        ans=Math.max(ans,pick);
        return dp[i][j]=pick;
    }
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        solve(0,0,dp,nums1,nums2);
        return ans;
    }
}