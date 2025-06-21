class Solution {
    public int minimumDeletions(String word, int k) {
        int res=Integer.MAX_VALUE;
        int[] arr=new int[26];
        for(char c:word.toCharArray()){
            arr[c-'a']++;
        }
        for(int x:arr){
            int curr=0;
            for(int a:arr){
                curr+=(a<x)?a:Math.max(0,a-(x+k));
            }
            res=Math.min(res,curr);
        }
        return res;
    }
}