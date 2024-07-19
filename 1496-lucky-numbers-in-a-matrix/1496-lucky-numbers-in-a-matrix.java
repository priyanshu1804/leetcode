class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        List<Integer> min=new ArrayList<>();
        for(int i=0;i<n;i++){
            int rmin=Integer.MAX_VALUE;
            for(int j=0;j<m;j++){
                rmin=Math.min(rmin,matrix[i][j]);
            }
            min.add(rmin);
        }
        List<Integer> max=new ArrayList<>();
        for(int j=0;j<m;j++){
            int cmax=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                cmax=Math.max(cmax,matrix[i][j]);
            }
            max.add(cmax);
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==min.get(i)&&matrix[i][j]==max.get(j)){
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }
}