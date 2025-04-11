class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int i=low;i<=high;i++){
            if(solve(i)){
                count++;
            }
        }
        return count;
    }
    public boolean solve(int num){
        String strNum=Integer.toString(num);
        int length=strNum.length();
        if(length%2==1){
            return false;
        }
        int n=length/2;
        int sumLeft=0;
        int sumRight=0;
        for(int i=0;i<n;i++){
            sumLeft+=Character.getNumericValue(strNum.charAt(i));
            sumRight+=Character.getNumericValue(strNum.charAt(length-1-i));
        }
        return sumLeft==sumRight;
    }
}