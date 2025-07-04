class Solution {
    int ans=Integer.MAX_VALUE;
    public int findShortestCycle(int n, int[][] edges) {
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
        for(int i=0;i<n;i++){
            int[] dist=new int[n];
            Arrays.fill(dist,Integer.MAX_VALUE);
            int[] parent=new int[n];
            Arrays.fill(parent,-1);
            Queue<Integer> q=new LinkedList<>();
            dist[i]=0;
            q.add(i);
            while(!q.isEmpty()){
                int node=q.poll();
                for(int it:adj.get(node)){
                    if(dist[it]==Integer.MAX_VALUE){
                        dist[it]=1+dist[node];
                        parent[it]=node;
                        q.add(it);
                    }else if(parent[node]!=it){
                        ans=Math.min(ans,dist[it]+dist[node]+1);
                    }
                }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}