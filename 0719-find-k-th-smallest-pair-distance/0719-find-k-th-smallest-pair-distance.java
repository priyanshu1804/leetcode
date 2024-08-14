class Solution {
    public int solve(int[] nums,int mid){
        int count=0;
        int i=0;
        int j=0;
        while(j<nums.length){
            while(nums[j]-nums[i]>mid){
                i++;
            }
            count+=j-i;
            j++;
        }
        return count;
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int min=nums[0];
        int max=nums[nums.length-1];
        int diff=max-min;
        int low=0;
        int high=diff;
        while(low<high){
            int mid=(low+high)/2;
            int count=solve(nums,mid);
            if(count<k){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
}