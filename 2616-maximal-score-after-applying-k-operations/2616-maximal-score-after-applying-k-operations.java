class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        long ans=0;
        while(k-->0){
            int max=pq.remove();
            ans+=(long)max;
            pq.add((max+2)/3);
        }
        return ans;
    }
}