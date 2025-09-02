class Solution {
    int mod=(int)1e9+7;
    public int solve(String s,int idx,int first,int second,int length,Integer[][][][] dp){
        if(length==5){
            return 1;
        }
        if(idx==s.length()){
            return 0;
        }
        if(dp[idx][first][second][length]!=null){
            return dp[idx][first][second][length];
        }
        int value=s.charAt(idx)-'0';
        int pick=0;
        if(length==0){
            pick=solve(s,idx+1,value,second,length+1,dp);
        }
        else if(length==1){
            pick=solve(s,idx+1,first,value,length+1,dp);
        }else if(length==2){
            pick=solve(s,idx+1,first,second,length+1,dp);
        }
        else if(length==3&&value==second){
            pick=solve(s,idx+1,first,second,length+1,dp);
        }else if(length==4&&value==first){
            pick=solve(s,idx+1,first,second,length+1,dp);
        }
        int notpick=solve(s,idx+1,first,second,length,dp);
        int ans=(pick%mod)+(notpick%mod);
        return dp[idx][first][second][length]=ans%mod;
    }
    public int countPalindromes(String s) {
        Integer[][][][] dp=new Integer[s.length()][10][10][5];
        return solve(s,0,0,0,0,dp);
    }
}