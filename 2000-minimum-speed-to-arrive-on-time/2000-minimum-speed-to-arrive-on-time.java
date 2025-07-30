class Solution {
    public boolean solve(int[] dist,int mid,double hour){
        double ans=0;
        for(int i=0;i<dist.length;i++){
            double d=dist[i]*1.0/mid;
            if(i!=dist.length-1){
                ans=ans+Math.ceil(d);
            }else{
                ans+=d;
            }
            if(ans>hour){
                return false;
            }
        }
        if(ans<=hour){
            return true;
        }
        return false;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int low=0;
        int high=(int)1e7;
        int min=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(solve(dist,mid,hour)){
                min=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return min;
    }
}