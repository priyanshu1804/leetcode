class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] ans=new double[n];
        ans[start_node]=1.0;
        for(int i=0;i<n-1;i++){
            boolean flag=false;
            for(int j=0;j<edges.length;j++){
                int u=edges[j][0];
                int v=edges[j][1];
                double dis=succProb[j];
                if(ans[u]*dis>ans[v]){
                    ans[v]=ans[u]*dis;
                    flag=true;
                }
                if(ans[v]*dis>ans[u]){
                    ans[u]=ans[v]*dis;
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }
        return ans[end_node];
    }
}