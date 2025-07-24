class Solution {
    int res=Integer.MAX_VALUE;
    int total;
    int[] val;
    List<List<Integer>> adj;
    public int dfs1(int node,int par,int ans,int anc){
        int xor=val[node];
        for(int it:adj.get(node)){
            if(it==par){
                continue;
            }
            xor^=dfs1(it,node,ans,anc);
        }
        if(par==anc){
            return xor;
        }
        int third=total^ans^xor;
        int max=Math.max(ans,Math.max(xor,third));
        int min=Math.min(ans, Math.min(xor,third));
        res=Math.min(res,max-min);
        return xor;
    }
    public int dfs(int node,int par){
        int xor=val[node];
        for(int it:adj.get(node)){
            if(it==par){
                continue;
            }
            xor^=dfs(it,node);
        }
        for(int it:adj.get(node)){
            if(it==par){
                dfs1(it,node,xor,node);
            }
        }
        return xor;
    }
    public int minimumScore(int[] nums, int[][] edges) {
        int n=nums.length;
        val=nums;
        total=0;
        for(int it:nums){
            total^=it;
        }
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:edges){
            int u=it[0];
            int v=it[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(0,-1);
        return res;
    }
}