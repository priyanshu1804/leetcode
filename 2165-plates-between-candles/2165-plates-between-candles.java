class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n=s.length();
        int[] pre=new int[n];
        int[] left=new int[n];
        int[] right=new int[n];
        pre[0]=s.charAt(0)=='*'?1:0;
        left[0]=s.charAt(0)=='|'?0:-1;
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+(s.charAt(i)=='*'?1:0);
            left[i]=s.charAt(i)=='|'?i:left[i-1];
        }
        right[n-1]=s.charAt(n-1)=='|'?n-1:n;
        for(int i=n-2;i>=0;i--){
            right[i]=s.charAt(i)=='|'?i:right[i+1];
        }
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int start=right[queries[i][0]];
            int end=left[queries[i][1]];
            ans[i]=(start>=end)?0:pre[end]-pre[start];
        }
        return ans;
    }
}