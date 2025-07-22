class Solution {
    public int solve(int node,boolean[] vis,int[] count,List<List<Integer>> adj){
        if(vis[node]){
            return count[0];
        }
        vis[node]=true;
        count[0]++;
        for(int it:adj.get(node)){
            solve(it,vis,count,adj);
        }
        return count[0];
    }
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:edges){
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }
        long sum=(Long.valueOf(n)*(n-1))/2;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                int ans=solve(i,vis,new int[1],adj);
                sum-=(Long.valueOf(ans)*(ans-1))/2;
            }
        }
        return sum;
    }
}