class pair{
    int u;
    int minutes;
    public pair(int u,int minutes){
        this.u=u;
        this.minutes=minutes;
    }
}
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int u=i;
            int v=manager[i];
            if(v!=-1){
                adj.get(v).add(u);
            }
        }
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(headID,0));
        int ans=0;
        while(!q.isEmpty()){
            pair curr=q.poll();
            int node=curr.u;
            int min=curr.minutes;
            ans=Math.max(ans,min);
            for(int it:adj.get(node)){
                q.add(new pair(it,min+informTime[node]));
            }
        }
        return ans;
    }
}