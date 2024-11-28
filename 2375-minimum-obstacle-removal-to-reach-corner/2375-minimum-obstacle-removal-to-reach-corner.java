class Solution {
    int[] row={0,0,1,-1};
    int[] col={1,-1,0,0};
    public int minimumObstacles(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] ans=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]=Integer.MAX_VALUE;
            }
        }
        ans[0][0]=grid[0][0];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{ans[0][0],0,0});
        while(!pq.isEmpty()){
            int[] it=pq.poll();
            int count=it[0];
            int r=it[1];
            int c=it[2];
            if(r==n-1&&c==m-1){
                return count;
            }
            for(int i=0;i<4;i++){
                int nrow=r+row[i];
                int ncol=c+col[i];
                if(nrow>=0&&ncol>=0&&nrow<grid.length&&ncol<grid[0].length){
                    int count1=count+grid[nrow][ncol];
                    if(count1<ans[nrow][ncol]){
                        ans[nrow][ncol]=count1;
                        pq.add(new int[]{count1,nrow,ncol});
                    }
                }
            }
        }
        return ans[n-1][m-1];
    }
}