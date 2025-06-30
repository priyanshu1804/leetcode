class Solution {
    public int solve2(int row,int col,int[][] fruits,int[][] dp){
        int n=fruits.length;
        if(row==n-1&&col==n-1){
            return 0;
        }
        if(row>(n-1)||col>(n-1)||(row<0)||(col<0)){
            return Integer.MIN_VALUE;
        } 
        if(row==col){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int op1=fruits[row][col]+solve2(row+1,col-1,fruits,dp);
        int op2=fruits[row][col]+solve2(row+1,col+1,fruits,dp);
        int op3=fruits[row][col]+solve2(row+1,col,fruits,dp);
        return dp[row][col]=Math.max(op1,Math.max(op2,op3));
    }
    public int solve1(int row,int col,int[][] fruits,int[][] dp){
        int n=fruits.length;
        if(row==n-1&&col==n-1){
            return 0;
        }
        if(row>(n-1)||col>(n-1)||(row<0)||(col<0)){
            return Integer.MIN_VALUE;
        } 
        if(row==col){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int op1=fruits[row][col]+solve1(row+1,col+1,fruits,dp);
        int op2=fruits[row][col]+solve1(row-1,col+1,fruits,dp);
        int op3=fruits[row][col]+solve1(row,col+1,fruits,dp);
        return dp[row][col]=Math.max(op1,Math.max(op2,op3));
    }
    public int maxCollectedFruits(int[][] fruits) {
        int n=fruits.length;
        int count1=0;
        for(int i=0;i<n;i++){
            count1+=fruits[i][i];
        }
        int[][] dp=new int[n][n];
        int[][] dp1=new int[n][n];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        for(int[] it:dp1){
            Arrays.fill(it,-1);
        }
        int count2=solve1(n-1,0,fruits,dp);
        int count3=solve2(0,n-1,fruits,dp1);
        return count1+count2+count3;
    }
}