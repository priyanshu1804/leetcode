class Solution {
    public long validSubstringCount(String word1, String word2) {
        int[] targetfreq=new int[26];
        for(int i=0;i<word2.length();i++){
            char ch=word2.charAt(i);
            targetfreq[ch-'a']++;
        }
        int i=0;
        int j=0;
        int[] currfreq=new int[26];
        long ans=0;
        while(j<word1.length()){
            int chIdx=word1.charAt(j)-'a';
            currfreq[chIdx]++;
            j++; 
            boolean flag=true;
            for(int k=0;k<26;k++){
                if(targetfreq[k]>currfreq[k]){
                    flag=false;
                    break;
                }
            }
            while(flag){
                ans+=(long)(word1.length()-j+1); 
                int leftChIdx=word1.charAt(i)-'a';
                currfreq[leftChIdx]--;
                i++;
                flag=true;
                for(int k=0;k<26;k++){
                    if(targetfreq[k]>currfreq[k]){
                        flag=false;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
