class Solution {
    public boolean solve(int[] quantities,int target,int n){
        if(target==0){
            return true;
        }
        int sum=0;
        for(int i=0;i<quantities.length;i++){
            sum+=(quantities[i]-1)/target+1;
            if(sum>n){
                return false;
            }
        }
        return true;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<quantities.length;i++){
            max=Math.max(quantities[i],max);
        }
        int low=1;
        int high=max;
        int ans=-1;
        while(low<=high){
            int mid=(high-low)/2+low;
            if(solve(quantities,mid,n)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}