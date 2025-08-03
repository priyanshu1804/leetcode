class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int i=0;
        int j=0;
        int max=0;
        for(i=0;i<n;i++){
            if(Math.abs(nums[i]-nums[j])>k*2){
                j++;
            }
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}