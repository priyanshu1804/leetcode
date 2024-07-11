class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last=new int[26];
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
        }
        int j=0;
        int count=0;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            j=Math.max(j,last[s.charAt(i)-'a']);
            if(i==j){
                ans.add(i-count+1);
                count=i+1;
            }
        }
        return ans;
    }
}