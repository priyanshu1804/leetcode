class pair{
    int first;
    int second;
    public pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    int dx[]={0,0,-1,1};
    int dy[]={-1,1,0,0};
    public void bfs(int[][] fire,int[][] grid,int n,int m){
        boolean[][] vis=new boolean[n][m];
        Queue<pair> q=new LinkedList<>();
        int time=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    vis[i][j]=true;
                    fire[i][j]=time;
                    q.add(new pair(i,j));
                }else if(grid[i][j]==2){
                    fire[i][j]=-1;
                }else{
                    fire[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        while(!q.isEmpty()){
            time++;
            int size=q.size();
            for(int i=0;i<size;i++){
                int x=q.peek().first;
                int y=q.peek().second;
                q.remove();
                for(int j=0;j<4;j++){
                    int nx=x+dx[j];
                    int ny=y+dy[j];
                    if(nx<0||ny<0||nx>=n||ny>=m||(fire[nx][ny]==-1)||vis[nx][ny]==true){
                        continue;
                    }
                    fire[nx][ny]=time;
                    vis[nx][ny]=true;
                    q.add(new pair(nx,ny));
                }
            }
        }
    }
    public boolean bfs1(int mid,int[][] fire,int n,int m){
        boolean[][] vis=new boolean[n][m];
        Queue<pair> q=new LinkedList<>();
        int time=mid;
        if(fire[0][0]<=time){
            return false;
        }
        q.add(new pair(0,0));
        vis[0][0]=true;
        while(!q.isEmpty()){
            time++;
            int size=q.size();
            for(int i=0;i<size;i++){
                int x=q.peek().first;
                int y=q.peek().second;
                q.remove();
                for(int j=0;j<4;j++){
                    int nx=x+dx[j];
                    int ny=y+dy[j];
                    if(nx<0||ny<0||nx>=n||ny>=m||(fire[nx][ny]==-1)||vis[nx][ny]==true){
                        continue;
                    }
                    if(nx==n-1&&ny==m-1&&time<=fire[n-1][m-1]){
                        return true;
                    }
                    if(time<fire[nx][ny]){
                        vis[nx][ny]=true;
                        q.add(new pair(nx,ny));
                    }
                }
            }
        }
        return false;
    }
    public int maximumMinutes(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] fire=new int[n][m];
        bfs(fire,grid,n,m);
        int ans=-1;
        int left=0;
        int right=n*m+1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(bfs1(mid,fire,n,m)){
                left=mid+1;
                ans=mid;
            }else{
                right=mid-1;
            }
        }
        return ans==n*m+1?(int)1e9:ans;
    }
}