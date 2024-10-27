class Solution {
    public int solve(int n,int m,int i,int j,int[][] matrix,int[][] moves,int[][] dp){
        if(i<0||j<0||i>=n||j>=m||matrix[i][j]==0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int res=Integer.MAX_VALUE;
        for(int[] it:moves){
            int x=i+it[0];
            int y=j+it[1];
            res=Math.min(res,1+solve(n,m,x,y,matrix,moves,dp));
        }
        return dp[i][j]=res;
    }
    public int countSquares(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] moves={{1,0},{0,1},{1,1}};
        int count=0;
        int[][] dp=new int[n+1][m+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    continue;
                }
                count+=solve(n,m,i,j,matrix,moves,dp);
            }
        }
        return count;
    }
}