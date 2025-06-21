class pair{
    int node;
    int weight;
    public pair(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
    int ans;
    public void solve(int node,int score,int time,List<List<pair>> adj,int[] values,int[] vis,int maxTime){
        if(time>maxTime){
            return;
        }
        if(vis[node]==0){
            score+=values[node];
        }
        if(node==0){
            ans=Math.max(ans,score);
        }
        vis[node]++;
        for(pair it:adj.get(node)){
            solve(it.node,score,time+it.weight,adj,values,vis,maxTime);
        }
        vis[node]--;
    }
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<values.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:edges){
            adj.get(it[0]).add(new pair(it[1],it[2]));
            adj.get(it[1]).add(new pair(it[0],it[2]));
        }
        int[] vis=new int[values.length];
        solve(0,0,0,adj,values,vis,maxTime);
        return ans;
    }
}