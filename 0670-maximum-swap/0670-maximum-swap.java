class Solution {
    public int maximumSwap(int num) {
        // boolean[] vis=new boolean[n];
        String str=Integer.toString(num);
        int n=str.length();
        int max=num;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                char[] arr=str.toCharArray();
                char temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                int ans=Integer.parseInt(new String(arr));
                max=Math.max(max,ans);
            }
        }
        return max;
    }
}