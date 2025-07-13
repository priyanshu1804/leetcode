class Solution {
    int mod=1000000007;
    public int solve(int i,int target,ArrayList<Integer> adj,int[][] dp){
        if(target==0){
            return 1;
        }
        if(i==adj.size()){
            return 0;
        }
        if(dp[i][target]!=-1){
            return dp[i][target];
        }
        int notpick=solve(i+1,target,adj,dp)%mod;
        int pick=0;
        if(adj.get(i)<=target){
            pick=solve(i+1,target-adj.get(i),adj,dp)%mod;;
        }
        return dp[i][target]=(pick+notpick)%mod;
    }
    public int numberOfWays(int n, int x) {
        ArrayList<Integer> adj=new ArrayList<>();
        for(int i=1;i<=n;i++){
            int temp=(int)Math.pow(i,x);
            if(temp<=n){
                adj.add(temp);
            }else{
                break;
            }
        }
        int[][] dp=new int[adj.size()+1][n+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,n,adj,dp);
    }
}