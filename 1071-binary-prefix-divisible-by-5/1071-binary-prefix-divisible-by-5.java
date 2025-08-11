class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans=new ArrayList<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            count=(count*2+nums[i])%5; 
            ans.add(count==0); 
        }
        return ans;
    }
}