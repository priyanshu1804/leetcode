class Solution {
    public int numberOfPairs(int[][] points){
        Arrays.sort(points,(a,b)->{
            if(a[0]!=b[0]){
                return b[0]-a[0];
            }
            return a[1]-b[1];
        });
        int n=points.length;
        int res=0;
        for(int i=0;i<n-1;i++){
            int y=Integer.MAX_VALUE;
            for(int j=i+1;j<n;j++){
                if(y>points[j][1]&&points[j][1]>=points[i][1]){
                    res++;
                    y=points[j][1];
                }
            }
        }
        return res;
    }
}