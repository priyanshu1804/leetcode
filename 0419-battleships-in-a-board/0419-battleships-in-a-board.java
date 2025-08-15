class Solution {
    public void dfs(char[][] board,int i,int j,boolean[][] vis){
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!='X'||vis[i][j]){
            return;
        }
        vis[i][j]=true; 
        dfs(board,i+1,j,vis);  
        dfs(board,i-1,j,vis);  
        dfs(board,i,j+1,vis);  
        dfs(board,i,j-1,vis);
    }
    public int countBattleships(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int count=0;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='X'&&!vis[i][j]){
                    dfs(board,i,j,vis);
                    count+=1;
                }
            }
        }
        return count;
    }
}