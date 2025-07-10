class Solution {
    public int solve(String s,int i,Integer[] dp){
        if(i==s.length()){
            return 0;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        int ans=0;
        boolean flag=false;
        for(int j=i;j<i+(s.length()-i)/2;j++){
            if(dp[j]==null){
                String a=s.substring(i,j+1);
                String b = s.substring(j+1,j+1+(j-i+1));
                if(a.equals(b)){
                    flag=true;
                    ans=Math.max(ans,1+solve(s,j+1,dp));
                }
            }
        }
        if(!flag){
            return dp[i]=1;
        }
        return dp[i]=ans;
    }
    public int deleteString(String s) {
        Integer[] dp=new Integer[s.length()];
        return solve(s,0,dp);
    }
}