class Solution {
    public int max(int[] arr){
        int n=arr.length ;
        int max1=arr[0];
        for(int it:arr){
            max1= Math.max(max1,it) ;
        }
        return max1; 
    }
    public boolean solve(int[] nums,int threshold,int mid){
        int sum=0 ;
        for(int it:nums){
            sum+=(it+mid-1)/mid; 
            if(sum>threshold){
                return false ;
            }
        }
        return (sum<=threshold) ;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int low=1;
        int high=max(nums);
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(solve(nums,threshold,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        } 
        return ans;
    }
}