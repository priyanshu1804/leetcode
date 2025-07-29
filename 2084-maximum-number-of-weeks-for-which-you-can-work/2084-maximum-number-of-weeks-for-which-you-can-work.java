class Solution {
    public long numberOfWeeks(int[] milestones) {
        int max=Integer.MIN_VALUE;
        int n=milestones.length;
        long sum=0;
        for(int it:milestones){
            max=Math.max(max,it);
            sum+=it;
        }
        long x=sum-max;
        if(max-x>1){
            return sum-(max-x-1);
        }
        return sum;
    }
}