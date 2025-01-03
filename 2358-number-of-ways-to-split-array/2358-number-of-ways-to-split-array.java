class Solution{
    public int waysToSplitArray(int[] nums){
        int n=nums.length;
        long[] pre=new long[n];
        pre[0]=(long)nums[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+(long)nums[i];
        }
        int count=0;
        for(int i=0;i<n-1;i++){
            if(pre[i]>=pre[n-1]-pre[i]){
                count++;
            }
        }
        return count;
    }
}