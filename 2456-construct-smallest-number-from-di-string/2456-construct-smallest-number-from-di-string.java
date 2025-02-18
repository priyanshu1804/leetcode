class Solution {
    public String smallestNumber(String pattern) {
        int n=pattern.length()+1;
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=i+1;
        }
        for(int i=0;i<pattern.length();i++){
            int temp=i;
            while(temp<pattern.length()&&pattern.charAt(temp)=='D'){
                temp++;
            }
            reverse(a,i,temp);
            if(temp!=i){
                i=temp-1;
            }
        }
        return Arrays.toString(a).replaceAll("\\[|\\]|,|\\s", "");
    }
    public void reverse(int[] a,int i,int temp){
        while(i<=temp){
            int k=a[i];
            a[i]=a[temp];
            a[temp]=k;
            i++;
            temp--;
        }
    }
}
