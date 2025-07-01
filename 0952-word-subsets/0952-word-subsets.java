class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] freq=new int[26];
        int[] temp=new int[26];
        for(String s:words2){
            Arrays.fill(temp,0);
            for(char ch:s.toCharArray()){
                temp[ch-'a']++;
            }
            for(int i=0;i<26;i++){
                freq[i]=Math.max(freq[i],temp[i]);
            }
        }
        List<String> ans=new ArrayList<>();
        for(String s:words1){
            Arrays.fill(temp,0);
            for(char ch:s.toCharArray()){
                temp[ch-'a']++;
            }
            boolean flag=true;
            for(int i=0;i<26;i++){
                if(freq[i]>temp[i]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                ans.add(s);
            }
        }
        return ans;
    }
}