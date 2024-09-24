class Solution {
    public boolean solve(int mountainHeight,int[] workerTimes,long mid){
        long total=0;
        for(int it:workerTimes){
            long max=(long)(-1+Math.sqrt(1+8*mid/it))/2;
            total+=max;
            if(total>=mountainHeight){
                return true;
            }
        }
        return total>=mountainHeight;
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low=1;
        long high=(long)1e18;
        while(low<high){
            long mid=low+(high-low)/2;
            if(solve(mountainHeight,workerTimes,mid)){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}