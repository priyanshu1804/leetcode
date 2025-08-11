class Solution {
    public static int mod=1000000007;
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> ans=new ArrayList<>();
        int count=1;
        while(n>0){
            if(n%2==1){
                ans.add(count);
            }
            n/=2;
            count*=2;
        }
        int m=ans.size();
        int[][] res=new int[m][m];
        for(int i=0;i<m;i++){
            long curr=1;
            for(int j=i;j<m;j++){
                curr=(curr*ans.get(j))%mod;
                res[i][j]=(int)curr;
            }
        }
        int[] ans1=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans1[i]=res[queries[i][0]][queries[i][1]];
        }
        return ans1;
    }
}