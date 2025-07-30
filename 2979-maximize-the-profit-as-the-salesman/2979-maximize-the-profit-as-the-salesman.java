class Solution {
    public int solve(int i,int n,List<Pair<Integer,Integer>>[] adj,int[] dp){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int nottake=solve(i+1,n,adj,dp);
        int take=0;
        for(Pair<Integer,Integer> val:adj[i]){
            int v=val.getKey();
            int w=val.getValue();
            take=Math.max(take,w+solve(v+1,n,adj,dp));
        }
        return dp[i]=Math.max(take,nottake);
    }
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        List<Pair<Integer,Integer>>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(List<Integer> offer:offers){
            int start=offer.get(0);
            int end=offer.get(1);
            int profit=offer.get(2);
            adj[start].add(new Pair<>(end,profit));
        }
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,n,adj,dp);
    }
}