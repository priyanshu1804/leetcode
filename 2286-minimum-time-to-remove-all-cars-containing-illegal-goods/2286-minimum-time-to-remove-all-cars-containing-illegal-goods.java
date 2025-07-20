class Solution {
    public int solve(String s,int idx,int count,int[][] dp){
        if(idx==s.length()){
            return 0;
        }
        if(dp[idx][count]!=-1){
            return dp[idx][count];
        }
        int time=Integer.MAX_VALUE;
        char curr=s.charAt(idx);
        for(int i=count;i<3;i++){
            int temp=Integer.MAX_VALUE;
            if(i==0||i==2){
                temp=1+solve(s,idx+1,i,dp);
            }else if(i==1){
                if(curr=='1'){
                    temp=2+solve(s,idx+1,i,dp);
                } else {
                    temp=solve(s,idx+1,i,dp);
                }
            } 
            time=Math.min(time,temp);
        }
        return dp[idx][count]=time;
    }
    public int minimumTime(String s) {
        int n=s.length()+1;
        int[][] dp=new int[n][3];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(s,0,0,dp);
    }
}