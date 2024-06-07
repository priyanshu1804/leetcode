class Solution {
    public String solve(String word,HashSet<String> set){
        for(int i=1;i<=word.length();i++){
            String ans=word.substring(0,i);
            if(set.contains(ans)){
                return ans;
            }
        }
        return word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] word=sentence.split(" ");
        HashSet<String> set=new HashSet<>(dictionary);
        for(int i=0;i<word.length;i++){
            word[i]=solve(word[i],set);
        }
        return String.join(" ",word);
    }
}