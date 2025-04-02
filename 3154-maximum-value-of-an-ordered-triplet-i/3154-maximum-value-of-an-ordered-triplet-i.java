class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        int[] pre=new int[n];
        int[] suff=new int[n];
        for(int i=1;i<n;i++){
            pre[i]=Math.max(pre[i-1],nums[i-1]);
            suff[n-1-i]=Math.max(suff[n-i],nums[n-i]);
        } 
        long ans=0;
        for(int i=1;i<n;i++){
            ans=Math.max(ans,(long)(pre[i]-nums[i])*suff[i]);
        }
        return ans;
    }
}