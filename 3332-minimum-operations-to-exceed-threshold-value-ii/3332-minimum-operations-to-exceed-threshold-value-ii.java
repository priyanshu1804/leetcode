class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add((long)nums[i]);
        }
        int count=0;
        while(pq.size()>=2&&pq.peek()<k){
            long x=pq.poll();
            long y=pq.poll();
            long z=(Math.min(x,y)*2+Math.max(x,y));
            pq.add(z);
            count++;
        }
        return count;
    }
}