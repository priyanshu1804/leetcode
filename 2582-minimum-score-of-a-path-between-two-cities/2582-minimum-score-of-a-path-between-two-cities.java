class pair{
    int node;
    int dist;
    public pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int w=roads[i][2];
            adj.get(u).add(new pair(v,w));
            adj.get(v).add(new pair(u,w));
        }
        Queue<pair> q=new LinkedList<>();
        boolean[] vis=new boolean[n+1];
        q.add(new pair(1,Integer.MAX_VALUE));
        int ans=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            pair curr=q.poll();
            int node=curr.node;
            int dist=curr.dist;
            vis[node]=true;
            ans=Math.min(ans,dist);
            for(pair it:adj.get(node)){
                if(!vis[it.node]){
                    q.add(it);
                }
            }
        }
        return ans;
    }
}