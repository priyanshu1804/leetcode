class Solution {
    public int minimizeMax(int[] nums, int p) {
        if(p==0){
            return 0;
        }
        Arrays.sort(nums);
        int n=nums.length;
        int low=0;
        int high=nums[n-1]-nums[0];
        while(low<high){
            int mid=low+(high-low)/2;
            int pair=0;
            for(int i=1;i<n;i++){
                if(nums[i]-nums[i-1]<=mid){
                    pair++;
                    i++;
                }
            }
            if(pair>=p){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}