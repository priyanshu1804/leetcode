class Solution {
    public int shortestPathLength(int[][] graph) {
        int n=graph.length;
        int finalmask=(1<<n)-1;
        Queue<int[]> q=new LinkedList<>();
        boolean[][] vis=new boolean[finalmask+1][n];
        for(boolean[] it:vis){
            Arrays.fill(it,false);
        }
        for(int i=0;i<n;i++){
            int mask=(1<<i);
            q.add(new int[]{i,mask,1});
            vis[mask][i]=true;
        }
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int node=curr[0];
            int mask=curr[1];
            int dist=curr[2];
            if(mask==finalmask){
                return dist-1;
            }
            for(int i=0;i<graph[node].length;i++){
                int it=graph[node][i];
                int newmask=mask|(1<<it);
                if(vis[newmask][it]){
                    continue;
                }
                q.add(new int[]{it,newmask,dist+1});
                vis[newmask][it]=true;
            }
        }
        return -1;
    }
}