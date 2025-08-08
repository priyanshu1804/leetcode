class Solution {
    public int solve(int x,int y,int z,int state,int[][][][] dp){
        if(dp[x][y][z][state]!=-1){
            return dp[x][y][z][state];
        }
        int max=0;
        if(x>0&&state!=1){
            max=Math.max(max,2+solve(x-1,y,z,1,dp));
        }
        if(y>0&&state!=3&&state!=2){
            max=Math.max(max,2+solve(x,y-1,z,2,dp));
        }
        if(z>0&&state!=1){
            max=Math.max(max,2+solve(x,y,z-1,3,dp));
        }
        return dp[x][y][z][state]=max;
    }
    public int longestString(int x, int y, int z) {
        int[][][][] dp=new int[x+1][y+1][z+1][4];
        for(int[][][] it:dp){
            for(int[][] it1:it){
                for(int[] it2:it1){
                    Arrays.fill(it2,-1);
                }
            }
        }
        int x1=2+solve(x-1,y,z,1,dp);
        int x2=2+solve(x,y-1,z,2,dp);
        int x3=2+solve(x,y,z-1,3,dp);
        return Math.max(x1,Math.max(x2,x3));
    }
}