class Solution {
    public long minimumDifference(int[] nums) {
        int n=nums.length/3;
        long[] pre=new long[2*n];
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        long sum=0;
        for(int i=0;i<2*n;i++){
            pq.add(nums[i]);
            sum+=nums[i];
            if(pq.size()>n){
                sum-=pq.remove();
            }
            if(pq.size()==n){
                pre[i]=sum;
            }
        }
        long[] suff=new long[2*n+1];
        PriorityQueue<Integer> pq1=new PriorityQueue<>();
        sum=0;
        for(int i=nums.length-1;i>=n;i--){
            pq1.add(nums[i]);
            sum+=nums[i];
            if(pq1.size()>n){
                sum-=pq1.remove();;
            }
            if(pq1.size()==n){
                suff[i]=sum;
            }
        }
        long ans=Long.MAX_VALUE;
        for(int i=n-1;i<2*n;i++){
            long left=pre[i];
            long right=suff[i+1];
            ans=Math.min(ans,left-right);
        }
        return ans;
    }
}