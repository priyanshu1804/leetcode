class Solution {
    int mod=(int)1e9+7;
    public int kConcatenationMaxSum(int[] arr, int k) {
        int n=arr.length;
        int m=k>1?2:1;
        long max=0;
        long curr=0;
        for(int i=0;i<m*n;i++){
            curr=Math.max(arr[i%n],curr+arr[i%n]);
            max=Math.max(max,curr);
        }
        long sum=0;
        for(int it:arr){
            sum+=it;
        }
        if(k==1){
            return (int)(max%mod);
        }
        if(sum>0){
            long ans=(sum*(k-2)+max)%mod;
            return (int)Math.max(ans,0);
        }else{
            return (int)Math.max(max,0)%mod;
        }
    }
}