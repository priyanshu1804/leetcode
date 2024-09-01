class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch='a';ch<='h';ch++){
            map.put(ch,ch -'a'+1);
        }
        int x=map.get(coordinate1.charAt(0))+Character.getNumericValue(coordinate1.charAt(1));
        int y=map.get(coordinate2.charAt(0))+Character.getNumericValue(coordinate2.charAt(1));
        if((x%2==0&&y%2==0)||(x%2!=0&&y%2!=0)){
            return true;
        }
        else{
            return false;
        }
    }
}