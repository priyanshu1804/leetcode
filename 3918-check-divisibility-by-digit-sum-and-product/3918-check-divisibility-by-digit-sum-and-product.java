class Solution {
    public boolean checkDivisibility(int n) {
        int pro=1;
        int sum=0;
        int x=n;
        while(x!=0){
            int y=x%10;
            pro*=y;
            sum+=y;
            x/=10;
        }
        return (n%(sum+pro)==0);
    }
}