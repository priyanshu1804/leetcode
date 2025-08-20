class Solution {
    public int solve(List<List<Integer>> piles,int i,int[][] dp,int k){
        if(i<0||k<=0){
            return 0;
        }
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        int notpick=solve(piles,i-1,dp,k);
        int n=Math.min(k,piles.get(i).size());
        int pick=0;
        int sum=0;
        for(int j=0;j<n;j++){
            sum+=piles.get(i).get(j);
            pick=Math.max(pick,sum+solve(piles,i-1,dp,k-j-1));
        }
        return dp[i][k]=Math.max(pick,notpick);
    }
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n=piles.size();
        int[][] dp=new int[n+1][k+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(piles,n-1,dp,k);
    }
}