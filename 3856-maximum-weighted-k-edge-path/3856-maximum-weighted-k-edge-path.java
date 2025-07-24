class pair{
    int v;
    int w;
    public pair(int v,int w){
        this.v=v;
        this.w=w;
    }
}
class Solution {
    int ans=-1;
    Map<String,Integer> dp=new HashMap<>();
    public void dfs(List<List<pair>> adj,int node,int cnt,int wt,int k,int t){
        if(wt>=t){
            return;
        }
        if(cnt==k){
            ans=Math.max(ans,wt);
            return;
        }
        String key=node+","+cnt+","+wt;
        if(dp.containsKey(key)&&dp.get(key)>=wt){
            return;
        }
        dp.put(key,wt);
        for(pair it:adj.get(node)){
            dfs(adj,it.v,cnt+1,wt+it.w,k,t);
        }
    }
    public int maxWeight(int n, int[][] edges, int k, int t) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:edges){
            int u=it[0];
            int v=it[1];
            int w=it[2];
            adj.get(u).add(new pair(v,w));
        }
        for(int i=0;i<n;i++){
            dfs(adj,i,0,0,k,t);
        }
        return ans;
    }
}