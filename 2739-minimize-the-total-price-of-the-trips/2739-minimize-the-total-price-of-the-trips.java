class Solution {
    List<List<Integer>> adj;
    int[][] dp;
    int[] freq;
    public int solve(int start,int parent,int flag,int[] price){
        if(dp[start][flag]!=-1){
            return dp[start][flag];
        }
        int full=freq[start]*price[start];
        int half=freq[start]*price[start]/2;
        for(int it:adj.get(start)){
            if(it!=parent){
                full+=solve(it,start,0,price);
            }
        }
        if(flag==1){
            return dp[start][flag]=full;
        }
        for(int it:adj.get(start)){
            if(it!=parent){
                half+=solve(it,start,1,price);
            }
        }
        return dp[start][flag]=Math.min(half,full);
    }
    public boolean dfs(int start,int end,int parent){
        if(start==end){
            return true;
        }
        for(int it:adj.get(start)){
            if(it!=parent)
            if(dfs(it,end,start)){
                freq[it]++;
                return true;
            }
        }
        return false;
    }
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        adj=new ArrayList<>();
        dp=new int[n+1][2];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        freq=new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:edges){
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }
        for(int[] it:trips){
            freq[it[0]]++;
            dfs(it[0],it[1],-1);
        }
        return solve(0,-1,0,price);
    }
}