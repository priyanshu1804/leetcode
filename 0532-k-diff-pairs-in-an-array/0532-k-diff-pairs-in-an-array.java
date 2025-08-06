class Solution {
    public int findPairs(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int count=0;
        int i=0;
        int j=1;
        while(j<n){
            int diff=nums[j]-nums[i];
            if(diff==k){
                count++;
                i++;
                j++;
                while(j<n&&nums[i]==nums[i-1]&&nums[j]==nums[j-1]){
                    i++;
                    j++;
                }
            }else if(diff>k){
                i++;
            }else{
                j++;
            }
            if(i==j){
                j++;
            }
        }
        return count;
    }
}