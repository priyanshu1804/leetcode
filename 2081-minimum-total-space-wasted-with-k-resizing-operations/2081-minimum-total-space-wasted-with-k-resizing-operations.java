class Solution {
    public int solve(int[] nums,int i,int k,int[][] dp){
        if(i>=nums.length){
            return 0;
        }
        if(k==-1){
            return 200*(int)1e6;
        }
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        int ans=200*(int)1e6;
        int max=nums[i];
        int sum=0;
        for(int j=i;j<nums.length;j++){
            max=Math.max(max,nums[j]);
            sum+=nums[j];
            ans=Math.min(ans,(j-i+1)*max-sum+solve(nums,j+1,k-1,dp));
        }
        return dp[i][k]=ans;
    }
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int[][] dp=new int[nums.length+1][k+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,0,k,dp);
    }
}