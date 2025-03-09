class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] arr=new int[colors.length+k-1];
        for(int i=0;i<colors.length;i++){
            arr[i]=colors[i];
        }
        for(int i=0;i<k-1;i++){
            arr[colors.length+i]=colors[i];
        }
        int n=arr.length;
        int ans=0;
        int i=0;
        int j=1;
        while(j<n){
            if(arr[j]==arr[j-1]){
                i=j;
                j++;
                continue;
            }
            j++;
            if(j-i<k){
                continue;
            }
            ans++;
            i++;
        }
        return ans;
    }
}