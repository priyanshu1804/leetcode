class Solution {
    public int minimumEffort(int[][] tasks){
        Arrays.sort(tasks,(a,b)->(b[1]-b[0])-(a[1]-a[0]));
        int l=0;
        int h=(int)1e9;
        int ans=0;
        while(l<=h){
            int m=l+(h-l)/2;
            int e=m;
            boolean ok=true;
            for(int[] t:tasks){
                if(e<t[1]){
                    ok=false;
                    break;
                }
                e-=t[0];
            }
            if(ok){
                ans=m;
                h=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
}
