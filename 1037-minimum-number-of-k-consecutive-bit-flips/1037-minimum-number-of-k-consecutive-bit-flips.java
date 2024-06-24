class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int count=0;
        int ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i>=k&&nums[i-k]==2){
                count++;
            }
            if(count%2==nums[i]){
                if(i+k>n){
                    return -1;
                }
                nums[i]=2;
                count++;
                ans++;
            }
        }
        return ans;
    }
}