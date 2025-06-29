class Solution {
    int count=0;
    public int solve(List<List<Integer>>adj,int node,int parent,int[] cost){
        if(adj.get(node).size()==1&&node!=0){
            return cost[node];
        }   
        List<Integer>ans=new ArrayList<>();
        for(int it:adj.get(node)){
            if(it==parent){
                continue;
            }
            int val=cost[node]+solve(adj,it,node,cost);
            ans.add(val);
        }
        int max=Collections.max(ans);
        for(int it:ans){
            if(it!=max){
                count++;
            }
        }
        return max;
    }
    public int minIncrease(int n, int[][] edges, int[] cost) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:edges){
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }
        solve(adj,0,-1,cost);
        return count;
    }
}