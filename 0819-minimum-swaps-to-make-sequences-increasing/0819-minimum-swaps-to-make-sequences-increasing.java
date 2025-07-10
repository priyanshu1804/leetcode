class Solution {
    public int solve(int[] nums1,int[] nums2,int idx,boolean flag,int[][] dp){
        if(idx==nums1.length){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        int prev1=idx==0?-1:nums1[idx-1];
        int prev2=idx==0?-1:nums2[idx-1];
        if(dp[idx][flag?1:0]!=-1){
            return dp[idx][flag?1:0];
        }
        if(flag){
            int temp=prev1; 
            prev1=prev2;
            prev2=temp;
        }
        if(nums1[idx]>prev1&&nums2[idx]>prev2){ 
            ans=solve(nums1,nums2,idx+1,false,dp);
        }
        if(nums1[idx]>prev2&&nums2[idx]>prev1){
            ans=Math.min(ans,1+solve(nums1,nums2,idx+1,true,dp));
        }
        return dp[idx][flag?1:0]=ans;
    }
    public int minSwap(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length][2];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(nums1,nums2,0,false,dp);
    }
}