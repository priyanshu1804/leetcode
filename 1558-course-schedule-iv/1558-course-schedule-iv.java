class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int u,int v){
        vis[u]=true;
        if(u==v){
            return true;
        }
        boolean ans=false;
        for(int it:adj.get(u)){
            if(!vis[it]){
                ans=ans||dfs(adj,vis,it,v);
            }
        }
        return ans;
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList());
        }
        for(int[] edge:prerequisites){
            adj.get(edge[0]).add(edge[1]);
        }
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            boolean[] vis=new boolean[numCourses];
            ans.add(dfs(adj,vis,queries[i][0],queries[i][1]));
        }
        return ans;
    }
}