class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if(cost1>total&&cost2>total){
            return 1;
        }
        if(cost1>total){
            return total/cost2+1;
        }
        if(cost2>total){
            return total/cost1+1;
        }
        long pen=(long)total/(long)cost1;
        long ans=0;
        for(int i=0;i<=pen;i++){
            long rem=(long)total-(i*(long)cost1);
            long x=rem/(long)cost2;;
            ans+=x+1;
        }
        return ans;
    }
}