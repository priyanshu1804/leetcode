class Solution {
    public boolean dfs1(int node,int parent,ArrayList<Integer> path, ArrayList<ArrayList<Integer>> adj){
        path.add(node); 
        if(node==0){
            return true;
        }
        for(int it:adj.get(node)){
            if(it!=parent){
                if(dfs1(it,node,path,adj)){
                    return true;
                }
            }
        }
        path.remove(path.size()-1);
        return false;
    }
    public int dfs2(int node,int parent,int count,int[] bobpath,ArrayList<ArrayList<Integer>> adj,int time,int[] amount){
        if(bobpath[node]==-1||bobpath[node]>time){
            count+=amount[node];
        }else if(bobpath[node]==time){
            count+=amount[node]/2;
        }
        if(adj.get(node).size()==1&&node!=0&&node!=parent){ 
            return count;
        }
        int max=Integer.MIN_VALUE;
        for(int it:adj.get(node)){
            if(it!=parent){ 
                max=Math.max(max,dfs2(it,node,count,bobpath,adj,time+1,amount));
            }
        }
        return max;
    }
    public int mostProfitablePath(int[][] edges,int bob,int[] amount){
        int n=amount.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:edges){
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }
        int[] bobpath=new int[n];
        Arrays.fill(bobpath,-1);
        ArrayList<Integer> path=new ArrayList<>();
        dfs1(bob,-1,path,adj);
        for(int i=0;i<path.size();i++){
            bobpath[path.get(i)]=i;
        }
        return dfs2(0,-1,0,bobpath,adj,0,amount);
    }
}
