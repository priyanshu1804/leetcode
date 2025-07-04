class Solution {
    public String lastNonEmptyString(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int[] last=new int[26];
        int max=0;
        Arrays.fill(last,-1);
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            last[ch-'a']=i;
            max=Math.max(map.get(ch),max);
        }
        StringBuilder sb=new StringBuilder();
        for (int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(map.get(ch)==max&&sb.indexOf(String.valueOf(ch))==-1){
                sb.append(ch);
            }
        }
        return sb.reverse().toString();
    }
}