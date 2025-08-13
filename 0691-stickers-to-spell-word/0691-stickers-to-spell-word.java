class Solution {
    public int solve(String[] stickers,String target,HashMap<String,Integer> dp,HashMap<String,HashMap<Character,Integer>> map){
        if(target.length()==0){
            return 0;
        }
        if(dp.containsKey(target)){
            return dp.get(target);
        }
        int ans=Integer.MAX_VALUE;
        for(String str:map.keySet()){
            HashMap<Character,Integer> map1=new HashMap<>(map.get(str));
            String temp=target;
            char ch=temp.charAt(0);
            if(map1.containsKey(ch)){
                for(int i=0;i<temp.length();i++){
                    ch=temp.charAt(i);
                    if(map1.containsKey(ch)&&map1.get(ch)>0){
                        map1.put(ch,map1.getOrDefault(ch,0)-1);
                        temp=temp.substring(0,i)+temp.substring(i+1);
                        i--;
                    }
                }
                if(temp.length()!=target.length()){
                    ans=Math.min(ans,1+solve(stickers,temp,dp,map));  
                    dp.put(target,ans);
                }
            }
        }
        return ans;
    }
    public int minStickers(String[] stickers, String target) {
        HashMap<String,HashMap<Character,Integer>> map=new HashMap<>();
        for(String str:stickers){
            HashMap<Character,Integer> map1=new HashMap<>();
            for(char ch:str.toCharArray()){
                map1.put(ch,map1.getOrDefault(ch,0)+1);
            }
            map.put(str,map1);
        }
        int ans=solve(stickers,target,new HashMap<>(),map);
        if(ans<1||ans>=Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}