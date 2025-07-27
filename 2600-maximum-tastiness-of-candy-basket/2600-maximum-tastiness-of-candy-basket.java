class Solution {
    public boolean solve(int mid,int[] price,int k){
        int prev=price[0];
        int count=1;
        for(int i=1;i<price.length;i++){
            if(price[i]-prev>=mid){
                count++;
                prev=price[i];
            }
            if(count==k){
                return true;
            }
        }
        return false;
    }
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n=price.length;
        int low=0;
        int high=price[n-1]-price[0];
        while(low<high){
            int mid=1+low+(high-low)/2;
            if(solve(mid,price,k)){
                low=mid;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
}