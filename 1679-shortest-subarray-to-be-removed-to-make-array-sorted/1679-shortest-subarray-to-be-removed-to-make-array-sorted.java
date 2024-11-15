class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int high=arr.length-1;
        while(high>0&&arr[high]>=arr[high-1]){
            high--;
        }
        int ans=high;
        int low=0;
        while(low<high&&(low==0||arr[low]>=arr[low-1])){
            while(high<arr.length&&arr[low]>arr[high]){
                high++;
            }
            ans=Math.min(ans,high-low-1);
            low++;
        }
        return ans;
    }
}