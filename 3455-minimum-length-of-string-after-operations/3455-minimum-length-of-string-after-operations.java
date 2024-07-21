class Solution {
    public int minimumLength(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int ans=0;
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if (entry.getValue()%2==1&&entry.getValue()>2){
                ans+=1;
            }else if(entry.getValue()%2==0&&entry.getValue()>2){
                ans+=2;
            }else{
                ans+=entry.getValue();
            }
        }
        return ans;
    }
}