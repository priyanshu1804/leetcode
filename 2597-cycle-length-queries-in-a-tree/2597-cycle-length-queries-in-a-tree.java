class Solution {
    public int solve(int[] arr){
        int ans=0;
        int a=arr[0];
        int b=arr[1];
        while(a!=b){
            if(a>b){
                a=a/2;
                ans++;
            }else{
                b=b/2;
                ans++;
            }
        }
        return ans+1;
    }
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int m=queries.length;
        int[] ans=new int[m];
        for(int i=0;i<m;i++){
            int k=solve(queries[i]);
            ans[i]=k;
        }
        return ans;
    }
}