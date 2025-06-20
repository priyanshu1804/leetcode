class Solution {
    public boolean checkValid(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            HashSet<Integer> row=new HashSet<>();
            for(int j=0;j<n;j++){
                if(!row.add(matrix[i][j])){
                    return false;
                }
            }
        }
        for(int j=0;j<n;j++){
            HashSet<Integer> col=new HashSet<>();
            for(int i=0;i<n;i++){
                if(!col.add(matrix[i][j])){
                    return false;
                }
            }
        }
        return true;
    }
}
