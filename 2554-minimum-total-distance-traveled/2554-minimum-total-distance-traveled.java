class Solution {
    public long solve(int i,int j,List<Integer> robot,List<Integer> pos,int[][] factory,long[][] dp){
        if(i==robot.size()){
            return 0;
        }
        if(j==pos.size()){
            return (long)1e16;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        long take=Math.abs(robot.get(i)-pos.get(j))+solve(i+1,j+1,robot,pos,factory,dp);
        long nottake=solve(i,j+1,robot,pos,factory,dp);
        return dp[i][j]=Math.min(take,nottake);
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,Comparator.comparingInt(a->a[0]));
        List<Integer> pos=new ArrayList<>();
        for(int[] fact:factory){
            int x=fact[0];
            int y=fact[1];
            for(int i=0;i<y;i++){
                pos.add(x);
            }
        }
        long[][] dp=new long[robot.size()+1][pos.size()+1];
        for(long[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,0,robot,pos,factory,dp);
    }
}