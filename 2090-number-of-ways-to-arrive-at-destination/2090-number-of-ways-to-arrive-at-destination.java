class Solution {
    private static final int MOD=1_000_000_007;
    private List<List<int[]>> adj;
    private long[] dist;
    private int n;
    private int dfs(int node,Map<Integer, Integer> memo) {
        if(node==n-1){
            return 1;
        }
        if(memo.containsKey(node)){
            return memo.get(node);
        }
        int ways=0;
        for(int[] neighbor:adj.get(node)){
            int v=neighbor[0];
            int time=neighbor[1];
            if(dist[node]+time==dist[v]){
                ways=(ways+dfs(v,memo))%MOD;
            }
        }
        memo.put(node,ways);
        return ways;
    }
    public int countPaths(int n, int[][] roads) {
        this.n=n;
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:roads){
            int u=it[0];
            int v=it[1];
            int time=it[2];
            adj.get(u).add(new int[]{v,time});
            adj.get(v).add(new int[]{u,time});
        }
        dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        PriorityQueue<long[]> pq=new PriorityQueue<>(Comparator.comparingLong(a->a[1]));
        pq.offer(new long[]{0,0});
        while(!pq.isEmpty()){
            long[] curr=pq.poll();
            int u=(int)curr[0];
            long d=curr[1];
            if(d>dist[u]){
                continue;
            }
            for(int[] it:adj.get(u)) {
                int v=it[0];
                long newDist=d+it[1];
                if(newDist<dist[v]) {
                    dist[v]=newDist;
                    pq.offer(new long[]{v,newDist});
                }
            }
        }
        return dfs(0, new HashMap<>());
    }
}