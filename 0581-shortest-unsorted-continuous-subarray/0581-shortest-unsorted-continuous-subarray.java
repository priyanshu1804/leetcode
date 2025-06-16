class Solution {
    public int findUnsortedSubarray(int[] arr) {
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int right=n;
        int left=0;
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            else if(arr[i]<max){
                right=i;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(arr[i]<min){
                min=arr[i];
            }
            else if(arr[i]>min){
                left=i;
            }
        }
        if(right-left+1>n){
            return 0;
        }
        return right-left+1;
    }
}