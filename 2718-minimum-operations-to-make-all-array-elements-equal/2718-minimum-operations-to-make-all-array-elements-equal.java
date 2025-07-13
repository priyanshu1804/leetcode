class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n=nums.length;
        int m=queries.length;
        List<Long> ans=new ArrayList<>();
        Arrays.sort(nums);
        long[] pre=new long[n];
        long[] suff=new long[n];
        pre[0]=nums[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        suff[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i]=suff[i+1]+nums[i];
        }
        for(int it:queries){
            long sum=0;
            int low=0;
            int high=n-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(nums[mid]<=it){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            sum+=low>0?((long)it*(long)low)-pre[low-1]:0;
            sum+=low<n?suff[low]-((long)(n-low)*(long)it):0;
            ans.add(sum);
        }
        return ans;
    }
}