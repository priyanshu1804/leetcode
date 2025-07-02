class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        int n=arr.length;
        long ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.abs((long)arr[i]-brr[i]);
        }
        int[] x=arr.clone();
        int[] y=brr.clone();
        Arrays.sort(x);
        Arrays.sort(y);
        long ans1=k;
        for (int i=0;i<n;i++){
            ans1+=Math.abs((long)x[i]-y[i]);
        }
        return Math.min(ans,ans1);
    }
}