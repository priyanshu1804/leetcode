class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        int n=original.length;
        int x=bounds[0][0];
        int y=bounds[0][1];
        for(int i=1;i<n;i++){
            int diff=original[i]-original[i-1];
            x=Math.max(x+diff,bounds[i][0]);
            y=Math.min(y+diff,bounds[i][1]);
            if(x>y){
                return 0;
            }
        }
        return y-x+1;
    }
}