class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] pre=new int[n];
        int[] suff=new int[n];
        pre[0]=height[0];
        for(int i=1;i<n;i++){
            pre[i]=Math.max(pre[i-1],height[i]);
        }
        suff[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i]=Math.max(suff[i+1],height[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int count=Math.min(pre[i],suff[i]);
            ans+=count-height[i];
        }
        return ans;
    }
}