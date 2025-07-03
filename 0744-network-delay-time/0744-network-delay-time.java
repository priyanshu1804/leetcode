class pair{
    int node;
    int dist;
    public pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:times){
            int u=it[0]-1;
            int v=it[1]-1;
            int w=it[2];
            adj.get(u).add(new pair(v,w));
        }
        PriorityQueue<pair> pq=new PriorityQueue<pair>((x,y)->x.dist-y.dist);
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1]=0;
        pq.add(new pair(k-1,0));
        while (!pq.isEmpty()){
            pair p=pq.poll();
            int dis=p.dist;
            int node=p.node;
            for(pair it:adj.get(node)) {
                int adjnode=it.node;
                int edgeWeight=it.dist;
                if(dis+edgeWeight<dist[adjnode]){
                    dist[adjnode]=dis+edgeWeight;
                    pq.add(new pair(adjnode,dist[adjnode]));
                }
            }
        }
        int time=0;
        for(int i:dist){
            if(i==Integer.MAX_VALUE){
                return -1;
            }
            time=Math.max(time,i);
        }
        return time;
    }
}