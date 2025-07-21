class Solution {
    int ans=0;
    HashMap<String,Integer> map=new HashMap<>();
    public void solve(String s,String t,int count,int length){
        if(length==0){
            return;
        }
        if(map.containsKey(s)){
            ans+=map.get(s);
            return;
        }
        int start=0;
        int end=length-1;
        int res=0;
        while(end<t.length()){
            String temp=t.substring(start,end+1);
            count=0;
            for(int i=0;i<length;i++){
                if(temp.charAt(i)!=s.charAt(i)){
                    count++;
                }
                if(count>1){
                    break;
                }
            }
            if(count==1){
                res++;
                ans++;
            }
            end++;
            start++;
        }
        map.put(s,res);
    }
    public int countSubstrings(String s, String t) {
        int start=0;
        int n=s.length();
        while(start<n){
            for(int i=start;i<n;i++){
                solve(s.substring(start,i+1),t,0,i+1-start);
            }
            start++;
        }
        return ans;
    }
}