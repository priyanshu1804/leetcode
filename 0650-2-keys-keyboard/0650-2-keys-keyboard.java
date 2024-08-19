class Solution {
    public int solve(int i,int j,int n){
        if(i==n){
            return 0;
        }
        if(i>n){
            return 1000;
        }
        int pickcopy=2+solve(2*i,i,n);
        int pickpaste=1+solve(i+j,j,n);
        return Math.min(pickcopy,pickpaste);
    }
    public int minSteps(int n) {
        if(n==1){
            return 0;
        }
        return solve(1,1,n)+1;
    }
}