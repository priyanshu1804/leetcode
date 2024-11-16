class Solution {
    public boolean solve(int i,int j,int[] nums){
        for(int k=i;k<j;k++){
            if(nums[k]>=nums[k+1]||nums[k]+1!=nums[k+1]){
                return false;
            }
        }
        return true;
    }
    public int[] resultsArray(int[] nums, int k) {
        int i=0;
        int j=k-1;
        int[] ans=new int[nums.length-k+1];
        while(j<nums.length){
            if(solve(i,j,nums)){
                ans[i]=nums[j];
            }else{
                ans[i]=-1;
            }
            i++;
            j++;
        }
        return ans;
    }
}