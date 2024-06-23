class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int i=0;
        int j=1;
        TreeSet<Integer> set=new TreeSet<>((a,b)->nums[a]==nums[b]?a-b:nums[a]-nums[b]);
        set.add(0);
        int ans=1;
        while(j<nums.length){
            set.add(j);
            while(nums[set.last()]-nums[set.first()]>limit){
                set.remove(i++);
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}