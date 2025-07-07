class Solution {
    public int countWays(int[][] ranges) {
        int mod=1000000007;
        int n=ranges.length;
        Arrays.sort(ranges,(a,b)->a[0]-b[0]);
        int ans=1;
        int end=ranges[0][1];
        for(int i=1;i<n;i++){
            if(ranges[i][0]<=end){
                end=Math.max(end,ranges[i][1]);
            }else{
                ans=(ans+1)%mod;
                end=ranges[i][1];
            }
        }
        long result=1;
        long base=2;
        while(ans>0){
            if((ans&1)==1){
                result=(result*base)%mod;
            }
            base=(base*base)%mod;
            ans>>=1;
        }
        return (int)result;
    }
}