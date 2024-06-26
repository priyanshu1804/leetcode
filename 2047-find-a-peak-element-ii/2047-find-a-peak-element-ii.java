class Solution {
    int[] row={-1,1,0,0};
    int[] col={0,0,-1,1};
    int n;
    int m;
    ArrayList<Integer> ans=new ArrayList<>();
    public boolean solve(int i,int j,int[][] mat){
        boolean flag=true;
        for(int k=0;k<4;k++){
            int nrow=i+row[k];
            int ncol=j+col[k];
            if(nrow<0||ncol<0||nrow>=n||ncol>=m){
                continue;
            }
            if(mat[nrow][ncol]>=mat[i][j]){
                flag=false;
            }
        }
        return flag==true;
    }
    public int[] findPeakGrid(int[][] mat) {
        n=mat.length;
        m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(solve(i,j,mat)){
                    ans.add(i);
                    ans.add(j);
                }
            }
        }
        int[] arr=new int[2];
        arr[0]=ans.get(ans.size()-2);
        arr[1]=ans.get(ans.size()-1);
        return arr;
    }
}