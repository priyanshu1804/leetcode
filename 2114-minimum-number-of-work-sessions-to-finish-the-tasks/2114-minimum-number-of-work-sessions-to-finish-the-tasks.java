class Solution {
    int[][] dp;
    int n;
    int[] tasks;
    int capacity;
    public int solve(int mask,int count){
        if(mask==(1<<n)-1){
            return 0;
        }
        if(dp[mask][count]!=-1){
            return dp[mask][count];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if((mask&(1<<i))==0){ 
                if(tasks[i]<=count){
                    ans=Math.min(ans,solve(mask|(1<<i),count-tasks[i]));
                }else{
                    ans=Math.min(ans,solve(mask|(1<<i),capacity-tasks[i])+1);
                }
            }
        }
        return dp[mask][count]=ans;
    }
    public int minSessions(int[] tasks,int sessionTime){
        this.tasks=tasks;
        this.n=tasks.length;
        this.capacity=sessionTime;
        dp=new int[1<<n][sessionTime+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,sessionTime)+1; 
    }
}
