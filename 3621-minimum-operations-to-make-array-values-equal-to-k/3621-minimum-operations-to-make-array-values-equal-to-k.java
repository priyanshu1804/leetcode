class Solution {
    public int minOperations(int[] nums, int k) {
        int min=Integer.MAX_VALUE;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            min=Math.min(nums[i],min);
            if(nums[i]>k){
                set.add(nums[i]);
            }
        }
        if(k>min){
            return -1;
        }
        return set.size();
    }
}