class Solution {
    public int minOperations(int n) {
        if(n==0||n==1){
            return 0;
        }
        int count=0;
        int i=0;
        int j=n-1;
        while(i<j){
            int left=2*i+1;
            int right=2*j+1;
            count+=(right-left)/2;
            i++;
            j--;
        }
        return count;
    }
}