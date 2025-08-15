class Solution {
    int n;
    int[] dp;
    Boolean[][] pal;
    public boolean solve1(String s,int i,int j){
        if(i>=j){
            return true;
        }
        if(pal[i][j]!=null){
            return pal[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            return pal[i][j]=solve1(s,i+1,j-1);
        }
        else{ 
            return pal[i][j]=false;
        }        
    }
    public int solve(String s,int idx,int k){
        if(idx>=n){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int notpick=solve(s,idx+1,k);
        int pick=0;
        for(int i=idx+k-1;i<n;i++){
            if(solve1(s,idx,i)){
                pick=Math.max(pick,1+solve(s,i+1,k));
            }
        }
        return dp[idx]=Math.max(pick,notpick);
    }
    public int maxPalindromes(String s, int k) {
        n=s.length();
        dp=new int[n];
        pal=new Boolean[n][n];
        Arrays.fill(dp,-1);
        return solve(s,0,k);
    }
}