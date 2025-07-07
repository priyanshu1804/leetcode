class Solution {
    public boolean solve(long mid,int totalTrips,int[] time){
        long ans=0;
        for(int it:time){
            ans+=mid/it;
        }
        if(ans>=totalTrips){
            return true;
        }
        return false;
    }
    public long minimumTime(int[] time, int totalTrips) {
        long low=Integer.MAX_VALUE;
        int n=time.length;
        for(int i=0;i<n;i++){
            low=Math.min(low,time[i]);
        }
        long high=totalTrips*low;
        while(low<high){
            long mid=low+(high-low)/2;
            if(solve(mid,totalTrips,time)){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}