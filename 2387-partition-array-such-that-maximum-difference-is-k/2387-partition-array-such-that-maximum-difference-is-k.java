class Solution {
    public int partitionArray(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int i=0;
        int j=0;
        int count=0;
        while(i<n&&j<n){
            if(nums[j]-nums[i]<=k){
                j++;
            }else{
                i=j;
                count++;
            }
        }
        return count+1;
    }
}