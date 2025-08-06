class unionfind{
    int[] par;
    long[] sum;
    public unionfind(int n){
        par=new int[n];
        sum=new long[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }
    int findpar(int x){
        if(this.par[x]==x){
            return x;
        }
        return this.par[x]=findpar(this.par[x]);
    }
    void union(int x,int y){
        int a=findpar(x);
        int b=findpar(y);
        par[b]=a;
        sum[a]+=sum[b];
    }
}
class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n=nums.length;
        long[] ans=new long[n];
        unionfind uf=new unionfind(n);
        long max=0;
        for(int i=n-1;i>=1;i--){
            int idx=removeQueries[i];
            uf.sum[idx]=nums[idx];
            if(idx+1<n&&uf.sum[idx+1]!=0){
                uf.union(idx,idx+1);
            }
            if(idx-1>-1&&uf.sum[idx-1]!=0){
                uf.union(idx,idx-1);
            }
            max=Math.max(max,uf.sum[idx]);
            ans[i-1]=max;
        }
        return ans;
    }
}