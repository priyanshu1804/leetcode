class Solution {
    public boolean solve(int[] nums,int max,int mid){
        int sum=0;
        for(int it:nums){
            int op=(int)Math.ceil(it/(double)mid)-1;
            sum+=op;
            if(sum>max){
                return false;
            }
        }
        return true;
    }
    public int minimumSize(int[] nums,int maxOperations){
        int left=1;
        int right=0;
        for(int it:nums){
            right=Math.max(right,it);
        }
        int ans=right;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(solve(nums,maxOperations,mid)){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}