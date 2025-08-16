class Solution {
    public int solve(int idx,int prev,List<Integer> nums,int[][] dp){
        if(idx==nums.size()){
            return 0;
        }
        if(dp[idx][prev+1]!=-1){
            return dp[idx][prev+1];
        }
        int op1=(int)1e9;
        int op2=(int)1e9;
        if(nums.get(idx)==prev){
            op1=solve(idx+1,nums.get(idx),nums,dp);
        }
        if(nums.get(idx)>prev){
            op1=solve(idx+1,nums.get(idx),nums,dp);
            op2=1+solve(idx+1,prev,nums,dp);
        }
        if(nums.get(idx)<prev){
            op2=1+solve(idx+1,prev,nums,dp);
        }
        return dp[idx][prev+1]=Math.min(op1,op2);
    }
    public int minimumOperations(List<Integer> nums) {
        int n=nums.size();
        int[][] dp=new int[n][5];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,-1,nums,dp);
    }
}