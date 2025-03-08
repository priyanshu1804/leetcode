class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<knowledge.size();i++){
            map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        int i=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch=='('){
                i++;
                StringBuilder sb1=new StringBuilder();
                while(i<s.length()&&s.charAt(i)!=')'){
                    sb1.append(s.charAt(i));
                    i++;
                }
                sb.append(map.containsKey(sb1.toString())?map.get(sb1.toString()):"?");
                i++;
                continue;
            }
            sb.append(ch);
            i++;
        }
        return sb.toString();
    }
}