class Solution {
    Map<Integer,Map<Integer,Integer>> adj;
    int[] dist;
    int mod=(int)1e9+7;
    public int dfs(int s,int e,Map<Integer,Map<Integer,Integer>> adj,int[] dp){
        if(s==e){
            return 1;
        }
        if(dp[s]!=-1){
            return dp[s];
        }
        long ans=0;
        if(adj.get(s)!=null){
            for(int v:adj.get(s).keySet()){
                if(dist[s]>dist[v]){
                    ans+=(dfs(v,e,adj,dp)%mod);
                }
            }
        }
        ans=(ans%mod);
        return dp[s]=(int)ans;
    }
    public int countRestrictedPaths(int n, int[][] edges) {
        dist=new int[n+1];
        adj=new HashMap<>();
        for(int[] it:edges){
            adj.putIfAbsent(it[0],new HashMap<>());
            adj.get(it[0]).put(it[1],it[2]);
            adj.putIfAbsent(it[1],new HashMap<>());
            adj.get(it[1]).put(it[0],it[2]);
        }
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{n,0});
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[n]=0;
        while(!pq.isEmpty()){
            int[] edge=pq.poll();
            int u=edge[0];
            int d=edge[1];
            if(dist[u]<d){
                continue;
            }
            if(adj.get(u)!=null){
                for(int v:adj.get(u).keySet()){
                    if(dist[v]>dist[u]+adj.get(u).get(v)){
                        dist[v]=dist[u]+adj.get(u).get(v);
                        pq.add(new int[]{v,dist[v]});
                    }
                }
            }
        }
        return dfs(1,n,adj,dp);
    }
}