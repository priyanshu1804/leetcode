class Solution {
    public int solve(int[] boxes,int i,int j,int k,Integer[][][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j][k]!=null){
            return dp[i][j][k];
        }
        int tempi=i;
        int tempk=k;
        while(i+1<=j&&boxes[i+1]==boxes[i]){
            i++;
            k++;
        }
        int ans=(k+1)*(k+1)+solve(boxes,i+1,j,0,dp);
        for(int l=i+1;l<=j;l++){
            if(boxes[i]==boxes[l]){
                ans=Math.max(ans,solve(boxes,i+1,l-1,0,dp)+solve(boxes,l,j,k+1,dp));
            }
        }
        return dp[tempi][j][tempk]=ans;
    }
    public int removeBoxes(int[] boxes) {
        int n=boxes.length;
        Integer[][][] dp=new Integer[n][n][n];
        return solve(boxes,0,n-1,0,dp);
    }
}