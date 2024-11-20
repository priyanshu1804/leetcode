class Solution {
    public int takeCharacters(String s, int k) {
        int[] arr=new int[3];
        int n=s.length();
        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
        for(int i=0;i<3;i++){
            if(arr[i]<k){
                return -1;
            }
        }
        int[] ans=new int[3];
        int i=0;
        int max=0;
        int j=0;
        while(j<n){
            ans[s.charAt(j)-'a']++;
            while(i<=j&&(arr[0]-ans[0]<k||arr[1]-ans[1]<k||arr[2]-ans[2]<k)){
                ans[s.charAt(i)-'a']--;
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return n-max;
    }
}