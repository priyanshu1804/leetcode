class Solution {
    List<int[]>[] adj;
    private static final int MOD=(int)2e9;
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            if(edge[2]!=-1){
                adj[edge[0]].add(new int[]{edge[1],edge[2]});
                adj[edge[1]].add(new int[]{edge[0],edge[2]});
            }
        }
        int currdis=solve(n,source,destination);
        if(currdis<target){
            return new int[0][0];
        }
        boolean flag=(currdis==target);
        for(int[] edge:edges){
            if(edge[2]!=-1){
                continue;
            }
            edge[2]=flag?MOD:1;
            adj[edge[0]].add(new int[]{edge[1],edge[2]});
            adj[edge[1]].add(new int[]{edge[0],edge[2]});
            if(!flag){
                int newdis=solve(n,source,destination);
                if(newdis<=target){
                    flag=true;
                    edge[2]+=target-newdis;
                }
            }
        }
        return flag?edges:new int[0][0];
    }
    public int solve(int n,int source,int destination){
        int[] mindis=new int[n];
        boolean[] vis=new boolean[n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        Arrays.fill(mindis,MOD);
        mindis[source]=0;
        pq.add(new int[]{source,0});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int u=curr[0];
            int d=curr[1];
            if(d>mindis[u]){
                continue;
            }
            for(int[] it:adj[u]){
                int v=it[0];
                int weight=it[1];
                if(d+weight<mindis[v]){
                    mindis[v]=d+weight;
                    pq.add(new int[]{v,mindis[v]});
                }
            }
        }
        return mindis[destination];
    }
}