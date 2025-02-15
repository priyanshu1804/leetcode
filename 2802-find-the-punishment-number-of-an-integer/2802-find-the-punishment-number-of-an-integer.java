class Solution {
    public boolean solve(int curr,int i){
        if(curr<i||i<0){
            return false;
        }
        if(curr==i){
            return true;
        }
        return solve(curr/10,i-(curr%10))||solve(curr/100,i-(curr%100))||solve(curr/1000,i-(curr%1000));
    }
    public int punishmentNumber(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            int curr=i*i;
            if(solve(curr,i)){
                ans+=curr;
            }
        }
        return ans;
    }
}