class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public void solve(int node,HashSet<Integer> set,List<List<Integer>> adj,boolean[] vis){
        vis[node]=true;
        for(int it:adj.get(node)){
            if(!vis[it]){
                set.add(it);
                solve(it,set,adj,vis);
            }
            set.add(it);
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:edges){
            adj.get(it[1]).add(it[0]);
        }
        for(int i=0;i<n;i++){
            boolean[] vis=new boolean[n];
            HashSet<Integer> set=new HashSet<>();
            solve(i,set,adj,vis);
            List<Integer> ds=new ArrayList<>(set);
            Collections.sort(ds);
            ans.add(ds);
        }
        return ans;
    }
}