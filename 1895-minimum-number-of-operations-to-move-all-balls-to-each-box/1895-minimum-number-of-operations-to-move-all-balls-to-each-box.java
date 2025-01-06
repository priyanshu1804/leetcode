class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=boxes.charAt(i)-'0';
        }
        int[] pre=new int[n];
        int[] suff=new int[n];
        int one=0;
        one=arr[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+one;
            one+=arr[i];
        }
        one=arr[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i]=suff[i+1]+one;
            one+=arr[i];
        }
        for(int i=0;i<n;i++){
            arr[i]=pre[i]+suff[i];
        }
        return arr;
    }
}