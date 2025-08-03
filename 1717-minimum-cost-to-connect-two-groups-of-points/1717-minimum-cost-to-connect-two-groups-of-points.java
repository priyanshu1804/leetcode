class Solution {
    int[][][] dp;
    public int solve(int idx1,int idx2,int mask,List<List<Integer>> cost,int size1,int size2){
        if(idx1==size1){
            return mask==(1<<size2)-1?0:(int) 1e9;
        }
        if(idx2>=size2){
            return (int)1e9;
        }
        if(dp[idx1][idx2][mask]!=-1){
            return dp[idx1][idx2][mask];
        }
        int op1=cost.get(idx1).get(idx2)+solve(idx1+1,0,mask|(1<<idx2),cost,size1,size2);
        int op2=cost.get(idx1).get(idx2)+solve(idx1,idx2+1,mask|(1<<idx2),cost,size1,size2);
        int op3=solve(idx1,idx2+1,mask,cost,size1,size2); 
        return dp[idx1][idx2][mask]=Math.min(op1,Math.min(op2,op3));
    }
    public int connectTwoGroups(List<List<Integer>> cost) {
        int size1=cost.size();
        int size2=cost.get(0).size();
        int mask=0;
        dp=new int[13][13][1<<13];
        for(int[][] it:dp){
            for(int[] row:it){
                Arrays.fill(row,-1);
            }
        }
        return solve(0,0,mask,cost,size1,size2);
    }
}
