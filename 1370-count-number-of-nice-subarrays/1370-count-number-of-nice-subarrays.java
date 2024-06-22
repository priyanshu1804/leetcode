class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        int i=0;
        int j=0;
        int ans=0;
        int count=0;
        int res=0;
        while(j<n){
            if(nums[j]%2!=0){
                count++;
                ans=0;
            }
            while(count==k){
                if(nums[i++]%2!=0){
                    count--;
                }
                ans++;
            }
            res+=ans;
            j++;
        }
        return res;
    }
}