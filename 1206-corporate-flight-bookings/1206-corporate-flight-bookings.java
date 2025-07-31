class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res=new int[n];
        for(int[] it:bookings){
            int first=it[0]-1;
            int last=it[1];
            int seat=it[2];
            res[first]+=seat;
            if(last<n){
                res[last]-=seat;
            }
        }
        for(int i=1;i<n;i++){
            res[i]+=res[i-1];
        }
        return res;
    }
}