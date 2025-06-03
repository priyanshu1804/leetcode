class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int ans=0;
        int n=status.length;
        boolean[] vis=new boolean[n];
        boolean[] vis1=new boolean[n];
        boolean[] vis2=new boolean[n];
        for(int i=0;i<n;i++){
            vis[i]=(status[i]==1);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int it:initialBoxes){
            vis1[it]=true;
            if(vis[it]){
                q.add(it);
                vis2[it]=true;
                ans+=candies[it];
            }
        }
        while(!q.isEmpty()){
            int u=q.poll();
            for(int it:keys[u]){
                vis[it]=true;
                if(!vis2[it]&&vis1[it]){
                    q.offer(it);
                    vis2[it]=true;
                    ans+=candies[it];
                }
            }
            for(int it:containedBoxes[u]){
                vis1[it]=true;
                if(!vis2[it]&&vis[it]){
                    q.offer(it);
                    vis2[it]=true;
                    ans+=candies[it];
                }
            }
        }
        return ans;
    }
}