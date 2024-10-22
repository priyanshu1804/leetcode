class Solution {
    public int countPrimes(int n) {
        int ans=0;
        boolean[] dp=new boolean[n+1];
        Arrays.fill(dp,true);
        dp[0]=false;
        if(n>0){
            dp[1]=false;
        }
        for(int i=2;i<n;i++){
            if(dp[i]){
                ans++;
                for(int j=i*2;j<n;j=j+i){
                    dp[j]=false;
                }
            }
        }
        return ans;
    }
}