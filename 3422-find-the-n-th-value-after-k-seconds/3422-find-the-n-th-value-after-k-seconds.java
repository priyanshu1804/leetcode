class Solution {
    public int valueAfterKSeconds(int n, int k) {
        int[] pre=new int[n];
        for(int i=0;i<n;i++){
            pre[i]=1;
        }
        while(k-->0){
            for(int i=1;i<n;i++){
                pre[i]=(pre[i]+pre[i-1])%1000000007;
            }
        }
        return pre[n-1]%1000000007;
    }
}