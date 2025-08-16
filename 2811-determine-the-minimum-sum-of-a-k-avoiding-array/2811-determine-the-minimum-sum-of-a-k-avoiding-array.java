class Solution {
    public int minimumSum(int n, int k) {
        Set<Integer> set=new HashSet();
        int ans=0;
        int m=2*n+1;
        for(int i=1;i<m;i++){
            if(n==0){
                break;
            }
            if(!set.contains(i)){
                ans+=i;
                n--;
                set.add(Math.abs(k-i));
            }
        }
        return ans;
    }
}