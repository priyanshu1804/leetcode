class pair{
    int row;
    int col;
    int val;
    public pair(int row,int col,int val){
        this.row=row;
        this.col=col;
        this.val=val;
    }
}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;
        boolean[][] vis=new boolean[n][m];
        PriorityQueue<pair> pq=new PriorityQueue<>(k,new Comparator<pair>(){
            @Override
            public int compare(pair c1,pair c2){
                if(c1.val==c2.val){
                    return 0;
                }
                return c1.val>c2.val?1:-1;
            }
        });
        pq.offer(new pair(0,0,matrix[0][0]));
        vis[0][0]=true;
        for(int i=0;i<k-1;i++){
            pair curr=pq.poll();
            if(curr.col+1<m&&!vis[curr.row][curr.col+1]){
                pq.offer(new pair(curr.row,curr.col+1,matrix[curr.row][curr.col+1]));
                vis[curr.row][curr.col+1]=true;
            }
            if(curr.row+1<n&&!vis[curr.row+1][curr.col]){
                pq.offer(new pair(curr.row+1,curr.col,matrix[curr.row+1][curr.col]));
                vis[curr.row+1][curr.col]=true;
            }
        }
        return pq.peek().val;
    }
}