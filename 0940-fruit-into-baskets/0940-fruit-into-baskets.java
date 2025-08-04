class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int n=fruits.length;
        int max=Integer.MIN_VALUE;
        while(j<n){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            while(map.size()>2){
                map.put(fruits[i],map.getOrDefault(fruits[i],0)-1);
                if(map.getOrDefault(fruits[i],0)==0){
                    map.remove(fruits[i]);
                }
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}