class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans=new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            ans[i]=-1;
            int it=nums.get(i);
            for(int j=0;j<it;j++){
                if((j|j+1)==it){
                    ans[i]=j;
                    break;
                }
            }
        }
        return ans;
    }
}