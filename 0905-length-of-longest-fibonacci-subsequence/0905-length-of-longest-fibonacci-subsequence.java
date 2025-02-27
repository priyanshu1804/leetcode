class Solution {
    public int solve(int[] arr,int i,int j,HashMap<Integer,Integer> map,int[][] dp){
        if(!map.containsKey(arr[i]+arr[j])){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        return dp[i][j]=1+solve(arr,j,map.get(arr[i]+arr[j]),map,dp);
    }
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        int[][] dp=new int[1001][1001];
        int max=0;
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }
        for(int i=0;i<arr.length-2;i++){
            for(int j=i+1;j<arr.length-1;j++){
                if(!map.containsKey(arr[i]+arr[j])){
                    continue;
                }
                max=Math.max(max,solve(arr,i,j,map,dp));
            }
        }
        if(max>0){
            return max+2;
        }
        return 0;
    }
}