class Solution {
    public int dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,List<Boolean> arr,int node){
        vis[node]=true;
        int ans=0;
        for(int it:adj.get(node)){
            if(!vis[it]){
                ans+=dfs(adj,vis,arr,it);
            }
        }
        if(node!=0&&(arr.get(node)||ans>0)){
            ans+=2;
        }
        return ans;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
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
        boolean[] vis=new boolean[n];
        return dfs(adj,vis,hasApple,0);
    }
}