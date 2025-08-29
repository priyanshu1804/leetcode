class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int it:nums){
            if(it%2!=0){
                it=it*2;
            }
            set.add(it);
        }
        int min=set.last()-set.first();
        while(set.last()%2==0){
            int last=set.last();
            set.remove(last);
            set.add(last/2);
            min=Math.min(min,set.last()-set.first());
        }
        return min;
    }
}