class Solution {
    public int findMinFibonacciNumbers(int k) {
        long[] dp=new long[101];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=100;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        //System.out.println(dp[300]);
        int ans=0;
        while(k>0){
            int low=0;
            int high=100;
            long ans1=0;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(dp[mid]<=k){
                    ans1=dp[mid];
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            k-=ans1;
            ans++;
        }
        return ans;
    }
}
