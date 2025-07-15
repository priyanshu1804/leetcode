class Solution {
    public double solve(int i,int k,int[] nums,double[][] dp){
        if(i==nums.length){
            return k==0?0.0:Double.NEGATIVE_INFINITY;
        }
        if(k==0){
            return Double.NEGATIVE_INFINITY;
        }
        if(dp[i][k]!=-1.0){
            return dp[i][k];
        }
        double ans=Double.NEGATIVE_INFINITY;
        double sum=0.0;
        for(int j=i;j<nums.length;j++){
            sum+=nums[j];
            double avg=sum/(j-i+1);
            ans=Math.max(ans,avg+solve(j+1,k-1,nums,dp));
        }
        return dp[i][k]=ans;
    }
    public double largestSumOfAverages(int[] nums, int k) {
        int n=nums.length;
        double[][] dp=new double[n][k+1];
        for(double[] it:dp){
            Arrays.fill(it,-1.0);
        }
        return solve(0,k,nums,dp);
    }
}