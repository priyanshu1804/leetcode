class Solution {
    public long cost;
    public long dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,int seats){
        if(adj.get(node).size()==1){
            cost++;
            return 1;
        }
        long people=1;
        for(int it:adj.get(node)){
            if(it==0||it==parent){
                continue;
            }
            people+=dfs(it,node,adj,seats);
        }
        cost+=people/seats+(people%seats==0?0:1);
        return people;
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=roads.length;
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        cost=0;
        for(int it:adj.get(0)){
            dfs(it,0,adj,seats);
        }
        return cost;
    }
}