class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        HashSet<Long> set=new HashSet<>();
        int[] arr={2,3,5};
        pq.add(1L);
        set.add(1L);
        long current=1L;
        for(int i=0;i<n;i++){
            current=pq.remove();
            for(int it:arr){
                long next=current*it;
                if(!set.contains(next)){
                    set.add(next);
                    pq.add(next);
                }
            }
        }
        return (int)current;
    }
}