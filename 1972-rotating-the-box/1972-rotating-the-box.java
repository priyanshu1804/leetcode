class Solution {
    public void reverse(char[] row){
        int left=0;
        int right=row.length-1;
        while(left<right){
            char temp=row[left];
            row[left]=row[right];
            row[right]=temp;
            left++;
            right--;
        }
    }
    public char[][] rotateTheBox(char[][] box) {
        int m=box.length;
        int n=box[0].length;
        char[][] ans=new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]=box[j][i];
            }
        }
        for(int i=0;i<n;i++){
            reverse(ans[i]);
        }
        for(int j=0;j<m;j++){
            int prev=n-1;
            for(int i=n-1;i>=0;i--){
                if(ans[i][j]=='#'){
                    ans[i][j]='.';
                    ans[prev][j]='#';
                    prev--;
                }
                if(ans[i][j]=='*'){
                    prev=i-1;
                }
            }
        }
        return ans;
    }
}