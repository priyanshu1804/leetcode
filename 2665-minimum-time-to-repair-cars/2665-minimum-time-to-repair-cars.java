class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low=1;
        long high=1L*ranks[0]*cars*cars;
        while(low<high){
            long mid=(low+high)/2;
            long total=0;
            for(int it:ranks){
                total+=(long)Math.sqrt((double)mid/it);
            }
            if(total<cars){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
}