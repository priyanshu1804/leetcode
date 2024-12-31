class Solution {
    public int solve1(int[] days,int i,boolean flag){
        int j=i+1;
        int skip=flag==true?7:30;
        while(j<days.length&&days[j]<days[i]+skip){
            j++;
        }
        return j;
    }
    public int solve(int[] days,int[] cost,int[] dp,int i){
        if(i==days.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int one=cost[0]+solve(days,cost,dp,i+1);
        int seven=cost[1]+solve(days,cost,dp,solve1(days,i,true));
        int thirty=cost[2]+solve(days,cost,dp,solve1(days,i,false));
        return dp[i]=Math.min(one,Math.min(seven,thirty));
    }
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp=new int[days.length+1];
        Arrays.fill(dp,-1);
        return solve(days,costs,dp,0);
    }
}