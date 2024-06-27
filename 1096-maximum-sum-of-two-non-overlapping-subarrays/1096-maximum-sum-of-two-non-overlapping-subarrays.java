class Solution {
    public int solve(int[] pre,int n,int m){
        int ans=0;
        int max=Integer.MIN_VALUE;
        for(int i=n+m;i<pre.length;i++){
            max=Math.max(max,pre[i-m]-pre[i-m-n]);
            ans=Math.max(ans,max+pre[i]-pre[i-m]);
        }
        return ans;
    }
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n=nums.length;
        int[] pre=new int[n+1];
        for(int i=0;i<n;i++){
            pre[i+1]=pre[i]+nums[i];
        }
        return Math.max(solve(pre,firstLen,secondLen),solve(pre,secondLen,firstLen));
    }
}