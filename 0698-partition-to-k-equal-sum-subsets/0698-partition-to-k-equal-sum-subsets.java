class Solution {
    public boolean solve(int[] nums,int n,int start,int k,int[] subsets,int target){
        if(start<0){
            return true;
        }
        for(int i=0;i<k;i++){
            if(subsets[i]+nums[start]>target||(i>0&&subsets[i]==subsets[i-1])){
                continue;
            }
            subsets[i]+=nums[start];
            if(solve(nums,n,start-1,k,subsets,target)){
                return true;
            }
            subsets[i]-=nums[start];
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int[] subset=new int[k];
        int sum=0;
        for(int it:nums){
            sum+=it;
        }
        if(sum%k!=0){
            return false;
        }
        int n=nums.length;
        int target=sum/k;
        Arrays.sort(nums);
        return solve(nums,n,n-1,k,subset,target);
    }
}