class Solution {
    public boolean solve(int n,int center,int r,int c){
        return (r==c&&r<=center )||((r+c+1)==n&&r<=center)||(r>center&&c==center);
    }
    public int minimumOperationsToWriteY(int[][] grid) {
        int n=grid.length;
        int center=n/2;
        int totaly=0;
        int totalnony=0;
        int[] freqy=new int[3];
        int[] freqnony=new int[3];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(solve(n,center,i,j)){
                    freqy[grid[i][j]]++;
                    totaly++;
                }else{
                    freqnony[grid[i][j]]++;
                    totalnony++;
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i==j){
                    continue;
                }
                int cost1=totaly-freqy[i];
                int cost2=totalnony-freqnony[j];
                min=Math.min(min,cost1+cost2);
            }
        }
        return min;
    }
}