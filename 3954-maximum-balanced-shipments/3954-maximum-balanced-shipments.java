class Solution {
    public int maxBalancedShipments(int[] arr) {
        int n=arr.length;
        int max=arr[0];
        int count=0;
        for(int i=1;i<n;i++){
            if(arr[i]<max){
                count++;
                max=0;
            }
            else{
                max=Math.max(max,arr[i]);
            }
        }
        return count;
    }
}