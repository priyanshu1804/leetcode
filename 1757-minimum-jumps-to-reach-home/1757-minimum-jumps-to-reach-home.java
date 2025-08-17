class Solution {
    HashSet<Integer> set=new HashSet<>();
    int[][] dp=new int[6001][2];
    public int solve(int i,int back,int a,int b,int x){
        if(i==x){
            return 0;
        }
        if(i<0||i>6000||back>=2||set.contains(i)){
            return (int)1e9;
        }
        if(dp[i][back]!=-1){
            return dp[i][back];
        }
        dp[i][back]=1+solve(i+a,0,a,b,x);
        if(back==0){
            dp[i][back]=Math.min(dp[i][back],1+solve(i-b,1,a,b,x));
        }
        return dp[i][back];
    }
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        for(int it:forbidden){
            set.add(it);
        }
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        int ans=solve(0,0,a,b,x);
        if(ans>1e9){
            return -1;
        }
        return ans;
    }
}