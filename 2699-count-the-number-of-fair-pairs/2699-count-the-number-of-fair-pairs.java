class Solution {
    public long solve(int[] nums,int low,int high,int target){
        while(low<=high){
            int mid=(high-low)/2+low;
            if(nums[mid]>=target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans=0;
        for(int i=0;i<nums.length;i++){
            long low=solve(nums,i+1,nums.length-1,lower-nums[i]);
            long high=solve(nums,i+1,nums.length-1,upper-nums[i]+1);
            ans+=1l*(high-low);
        }
        return ans;
    }
}