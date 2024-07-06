class Solution {
    public int passThePillow(int n, int time) {
        int count=time/(n-1);
        int ans=time%(n-1);
        if(count%2==0){
            return ans+1;
        }
        return n-ans;
    }
}