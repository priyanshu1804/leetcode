class Solution {
    public boolean solve(int[] nums,int[][] queries,int k){
        int n=nums.length;
        int sum=0;
        int[] diff=new int[n+1];
        for(int i=0;i<k;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            int w=queries[i][2];
            diff[l]+=w;
            diff[r+1]-=w;
        }  
        for(int i=0;i<n;i++){
            sum+=diff[i];
            if(sum<nums[i]){
                return false;
            }
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int left=0;
        int right=queries.length;
        if(!solve(nums,queries,right)){
            return -1;
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(solve(nums,queries,mid)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}