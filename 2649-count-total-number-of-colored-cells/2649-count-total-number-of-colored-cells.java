class Solution {
    // int[] dp=new int[100001];
    // dp[1]=1;
    // for(int i=2;i<=100000;i++){
    //     dp[i]=dp[i-1]+(i-1)*4;
    // }
    public long coloredCells(int n) {
        long[] dp=new long[100001];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+(i-1)*4;
        }
        return dp[n];
    }
}