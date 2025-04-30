class Solution {
    public int countSubarrays(int[] arr) {
        int i=0;
        int j=2;
        int count=0;
        while(j<arr.length){
            if(arr[i]+arr[j]==(arr[i+1]/2)&&arr[i+1]%2==0){
                count++;
            }
            i++;
            j++;
        }
        return count;
    }
}