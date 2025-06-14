class pair{
    int node;
    long weight;
    public pair(int node,long weight){
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
    public void solve(List<List<pair>> adj,int src,long[] ans){
        int n=adj.size();
        int vis[]=new int[n];
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{return Long.compare(a.weight,b.weight);});
        vis[src]=1;
        pq.add(new pair(src,0));
        ans[src]=0;
        while(pq.size()>0){
            pair x=pq.remove();
            if(ans[x.node]<x.weight) {
                continue;
            }
            for(pair it:adj.get(x.node)){
                if(ans[it.node]>x.weight+it.weight){
                    ans[it.node]=x.weight+it.weight;
                    pq.add(new pair(it.node,x.weight+it.weight));
                }
            }
        }
    }
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<List<pair>> adj=new ArrayList<>();
        List<List<pair>> adj1=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            adj1.add(new ArrayList<>());
        }
        for(int[] it:edges){
            int u=it[0];
            int v=it[1];
            int w=it[2];
            adj.get(u).add(new pair(v,w));
            adj1.get(v).add(new pair(u,w));
        }
        long[] dist1=new long[n];
        long[] dist2=new long[n];
        long[] dist3=new long[n];
        Arrays.fill(dist1,Long.MAX_VALUE);
        Arrays.fill(dist2,Long.MAX_VALUE);
        Arrays.fill(dist3,Long.MAX_VALUE);
        solve(adj,src1,dist1);
        solve(adj,src2,dist2);
        solve(adj1,dest,dist3);
        long ans=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(dist1[i]!=Long.MAX_VALUE&&dist2[i]!=Long.MAX_VALUE&dist3[i]!=Long.MAX_VALUE){
                long temp=dist1[i]+dist2[i]+dist3[i];
                ans=Math.min(ans,temp);
            }
        }
        return ans==Long.MAX_VALUE?-1:ans;
    }
}