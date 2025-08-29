class Solution {
    public int solve(int[][] cuboids,int idx,int prev,int[][] dp){
        if(idx>=cuboids.length){
            return 0;
        }
        if(dp[idx][prev+1]!=-1){
            return dp[idx][prev+1];
        }
        int pick=0;
        if(prev==-1||(cuboids[idx][0]>=cuboids[prev][0]&&cuboids[idx][2]>=cuboids[prev][2]&&cuboids[idx][1]>=cuboids[prev][1])){
            pick=cuboids[idx][2]+solve(cuboids,idx+1,idx,dp);
        }
        int notpick=solve(cuboids,idx+1,prev,dp);
        return dp[idx][prev+1]=Math.max(pick,notpick);
    }
    public int maxHeight(int[][] cuboids) {
        for(int[] it:cuboids){
            Arrays.sort(it);
        }
        Arrays.sort(cuboids,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(a[0]!=b[0]){
                    return Integer.compare(a[0],b[0]);
                }
                else if(a[1]!=b[1]){
                    return Integer.compare(a[1],b[1]);
                }else{
                    return Integer.compare(a[2],b[2]);
                }
            }
        });
        int[][] dp=new int[cuboids.length][cuboids.length+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(cuboids,0,-1,dp);
    }
}