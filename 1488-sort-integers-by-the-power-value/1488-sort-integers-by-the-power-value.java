class Solution {
    Integer[] dp;
    public int solve(int n){
        if(n==1){
            return 0;
        }
        if(dp[n]!=null){
            return dp[n];
        }
        int count=0;
        if(n%2==0){
            count=1+solve(n/2);
        }
        else{
            count=1+solve(3*n+1);
        }
        dp[n]=count;
        return count;
    }
    public int getKth(int lo, int hi, int k) {
        int[][] arr=new int[hi-lo+1][2];
        dp=new Integer[1000001];
        int idx=0;
        for(int i=lo;i<=hi;i++){
            arr[idx][0]=i;
            arr[idx][1]=solve(i);
            idx++;
        }
        Arrays.sort(arr,(a,b)->(a[1]-b[1]));
        return arr[k-1][0];
    }
}