class Solution {
    public boolean solve(int[] nums,int mid,int k){
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=mid){
                count++;
                i++;
            }
            if(count>=k){
                return true;
            }
        }
        return false;
    }
    public int minCapability(int[] nums, int k) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        int low=min;
        int high=max;
        while(low<high){
            int mid=low+(high-low)/2;
            if(solve(nums,mid,k)){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}