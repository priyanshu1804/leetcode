class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int j=0;
        int i=0;
        int n=nums.length;
        int sum=0;
        int max=Integer.MIN_VALUE;
        Set<Integer> set=new HashSet<>();
        while(j<n){
            sum+=nums[j];
            while(set.contains(nums[j])){
                sum-=nums[i];
                set.remove(nums[i]);
                i++;
            }
            max=Math.max(max,sum);
            set.add(nums[j]);
            j++;
        }
        return max;
    }
}