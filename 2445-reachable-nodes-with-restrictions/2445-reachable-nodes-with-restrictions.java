class Solution {
    int count;
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,int n,boolean[] vis){
        vis[node]=true;
        count++;
        for(int it:adj.get(node)){
            if(!vis[it]){
                dfs(it,adj,n,vis);
            }
        }
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:edges){
            int u=it[0];
            int v=it[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        count=0;
        boolean[] vis=new boolean[n];
        for(int it:restricted){
            vis[it]=true;
        }
        dfs(0,adj,n,vis);
        return count;
    }
}