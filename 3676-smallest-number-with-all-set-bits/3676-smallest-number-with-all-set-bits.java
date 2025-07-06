class Solution {
    public int smallestNumber(int n) {
        int count=2;
        while(count<=n){
            count*=2;
        }
        return count-1;
    }
}