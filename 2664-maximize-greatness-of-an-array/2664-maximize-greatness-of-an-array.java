class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        for(int it:nums){
            if(nums[i]<it){
                i++;
            }
        }
        return i;
    }
}