class Solution {
    private void solve(int node,Set<Integer>[] adj,int[] vis,int count){
        vis[node]=count;
        for(Integer it:adj[node]){
            if(vis[it]==0){
                solve(it,adj,vis,count);
            }
        }
    }
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        Set<Integer>[] adj=new HashSet[n];
        for(int i=0;i<n;i++){
            adj[i]=new HashSet<>();
        }
        for(int i=threshold+1;i<=n/2;i++){
            for(int j =2*i;j<=n;j+=i){
                adj[i-1].add(j-1);
                adj[j-1].add(i-1);
            }
        }
        int[] vis=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                count++;
                solve(i,adj,vis,count);
            }
        }
        List<Boolean> result=new ArrayList<>();
        for(int[] query:queries){
            result.add(vis[query[0]-1]==vis[query[1]-1]);
        }
        return result;
    }
}