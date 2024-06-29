class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public void solve(int node,List<List<Integer>> adj,boolean[] vis,HashSet<Integer> set){
        vis[node]=true;
        for(int it:adj.get(node)){
            if(vis[it]==false){
                set.add(it);
                solve(it,adj,vis,set);
            }
            set.add(it);
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            adj.get(e[1]).add(e[0]);
        }
        for(int i=0;i<n;i++){
            boolean[] vis=new boolean[n];
            HashSet<Integer> set=new HashSet<>();
            solve(i,adj,vis,set);
            ArrayList<Integer> ds=new ArrayList<>(set);
            Collections.sort(ds);
            ans.add(ds);
        }
        return ans;
    }
}