class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n=nums.length;
        int[] lis=new int[n];
        int[] lid=new int[n];
        Arrays.fill(lis,1);
        Arrays.fill(lid,1);
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    lis[i]=Math.max(lis[i],lis[j]+1);
                }
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(nums[i]>nums[j]){
                    lid[i]=Math.max(lid[i],lid[j]+1);
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(lis[i]>1&&lid[i]>1){
                ans=Math.min(ans,n-lis[i]-lid[i]+1);
            }
        }
        return ans;
    }
}