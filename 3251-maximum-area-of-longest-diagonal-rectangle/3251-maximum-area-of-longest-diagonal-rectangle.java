class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans=-1;
        double max=Double.MIN_VALUE;
        int n=dimensions.length;
        for(int i=0;i<n;i++){
            int x=dimensions[i][0];
            int y=dimensions[i][1];
            double z=Math.sqrt((x*x)+(y*y));
            //System.out.println(z);
            if(z>max){
                ans=x*y;
                max=z;
            }else if(z==max){
                ans=Math.max(ans,x*y);
                max=z;
            }
        }
        return ans;
    }
}