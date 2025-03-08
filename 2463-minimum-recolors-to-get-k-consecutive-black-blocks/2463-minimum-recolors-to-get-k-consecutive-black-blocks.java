class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        int i=0;
        int j=0;
        int min=Integer.MAX_VALUE;
        HashMap<Character,Integer> map=new HashMap<>();
        while(j<n){
            map.put(blocks.charAt(j),map.getOrDefault(blocks.charAt(j),0)+1);
            if(j-i+1==k){
                min=Math.min(min,map.getOrDefault('W',0));
                map.put(blocks.charAt(i),map.getOrDefault(blocks.charAt(i),0)-1);
                if(map.getOrDefault(blocks.charAt(i),0)==0){
                    map.remove(blocks.charAt(i));
                }
                i++;
            }
            j++;
        }
        return min;
    }
}