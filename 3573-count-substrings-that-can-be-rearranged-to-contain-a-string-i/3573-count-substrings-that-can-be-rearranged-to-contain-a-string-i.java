class Solution {
    public boolean solve(int[] freq1,int[] freq2){
        for(int i=0;i<26;i++){
            if(freq2[i]<freq1[i]){
                return false;
            }
        }
        return true;
    }
    public long validSubstringCount(String word1, String word2) {
        int[] freq1=new int[26];
        for(int i=0;i<word2.length();i++){
            freq1[word2.charAt(i)-'a']++;
        } 
        long ans=0;
        int i=0;
        int j=0;
        int n=word1.length();
        int m=word2.length();
        int[] freq2=new int[26];
        while(i<n){
            freq2[word1.charAt(i)-'a']++;
            while(solve(freq1,freq2)&&j<=i){
                ans+=n-i;
                freq2[word1.charAt(j)-'a']--;
                j++;
            }
            i++;
        }
        return ans;
    }
}