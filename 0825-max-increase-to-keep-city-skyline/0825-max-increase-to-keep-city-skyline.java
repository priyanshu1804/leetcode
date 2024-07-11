class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] row=new int[n];
        int[] col=new int[m];
        for(int i=0;i<n;i++){
            row[i]=grid[i][0];
            col[i]=grid[0][i];
            for(int j=0;j<m;j++){
                row[i]=Math.max(row[i],grid[i][j]);
                col[i]=Math.max(col[i],grid[j][i]);
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=Math.min(col[j],row[i])-grid[i][j];
            }
        }
        return sum;
    }
}