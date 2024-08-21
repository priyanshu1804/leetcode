class Solution {
    public String duplicate(String s){
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<s.length()){
            char curr=s.charAt(i);
            sb.append(curr);
            while(i<s.length()&&s.charAt(i)==curr){
                i++;
            }
        }
        return sb.toString();
    }
    public int solve(int i,int j,String s,int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=1+solve(i+1,j,s,dp);
        for(int k=i+1;k<=j;k++){
            if(s.charAt(k)==s.charAt(i)){
                int turn=solve(i,k-1,s,dp)+solve(k+1,j,s,dp);
                min=Math.min(min,turn);
            }
        }
        return dp[i][j]=min;
    }
    public int strangePrinter(String s) {
        s=duplicate(s);
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,n-1,s,dp);
    }
}