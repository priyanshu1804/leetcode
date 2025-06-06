class Solution {
    public String robotWithString(String s) {
        Stack<Character> st=new Stack<>();
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        char min='a';
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            st.push(ch);
            map.put(ch,map.getOrDefault(ch,0)-1);
            while(min!='z'&&map.getOrDefault(min,0)==0){
                min++;
            }
            while(!st.isEmpty()&&st.peek()<=min){
                sb.append(st.pop());
            }
        }
        return sb.toString();
    }
}