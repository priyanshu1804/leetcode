class pair implements Comparable<pair>{
    int first;
    int second;
    int dist;
    public pair(int first,int second,int dist){
        this.first=first;
        this.second=second;
        this.dist=dist;
    }
    @Override
    public int compareTo(pair other){
        return Integer.compare(this.dist, other.dist);
    }
}
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length;
        int m=moveTime[0].length;
        int[][] dp=new int[n][m];
        for(int[] it:dp){
            Arrays.fill(it,Integer.MAX_VALUE);
        }
        boolean[][] vis=new boolean[n][m];
        PriorityQueue<pair> pq=new PriorityQueue<>();
        dp[0][0]=0;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        pq.offer(new pair(0, 0, 0));
        while(!pq.isEmpty()){
            pair node=pq.poll();
            if(vis[node.first][node.second]){
                continue;
            }
            vis[node.first][node.second]=true;
            for(int[] dir:dirs){
                int nrow=node.first+dir[0];
                int ncol=node.second+dir[1];
                if(nrow<0||nrow>=n||ncol<0||ncol>=m){
                    continue;
                }
                int dist=Math.max(dp[node.first][node.second],moveTime[nrow][ncol])+((node.first+node.second)%2)+1;

                if(dp[nrow][ncol]>dist){
                    dp[nrow][ncol]=dist;
                    pq.offer(new pair(nrow,ncol,dist));
                }
            }
        }
        return dp[n-1][m-1];
    }
}