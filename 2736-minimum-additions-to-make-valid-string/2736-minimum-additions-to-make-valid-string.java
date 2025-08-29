class Solution {
    public int addMinimum(String word) {
        int i=0;
        int j=0;
        String s="abc";
        int n=word.length();
        int count=0;
        while(i<n){
            if(word.charAt(i)==s.charAt(j)){
                i++;
            }
            else{
                count++;
            }
            j=(j+1)%3;
        }
        count+=(3-j)%3;
        return count;
    }
}