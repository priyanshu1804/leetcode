class Solution {
    public String breakPalindrome(String palindrome) {
        char[] arr=palindrome.toCharArray();
        int n=arr.length;
        if(n<=1){
            return "";
        }
        for(int i=0;i<n/2;i++){
            if(arr[i]!='a'){
                arr[i]='a';
                return new String(arr);
            }
        }
        arr[arr.length-1]='b';
        return new String(arr);
    }
}