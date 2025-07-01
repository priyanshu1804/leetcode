class Solution {
    int max=1;
    List<Integer>[] adj;
    public int dfs(int node,int parent,String s){
        int max1=0;
        int max2=0;
        for(int it:adj[node]){
            if(it==parent){
                continue;
            }
            int max3=dfs(it,node,s);
            if(s.charAt(it)==s.charAt(node)){
                continue;
            }
            if(max3>max1){
                max2=max1;
                max1=max3;
            }
            else if(max3>max2){
                max2=max3;
            }
            max=Math.max(max,max1+max2+1);
        }
        return max1+1;
    }
    public int longestPath(int[] parent, String s) {
        int n=parent.length;
        adj=new List[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=1;i<n;i++){
            int u=i;
            int v=parent[i];
            adj[u].add(v);
            adj[v].add(u);
        }
        dfs(0,-1,s);
        return max;
    }
}