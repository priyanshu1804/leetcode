class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<target.length;i++){
            map.put(target[i],map.getOrDefault(target[i],0)+1);
        }
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.getOrDefault(arr[i],0)-1);
                if(map.get(arr[i])==0){
                    map.remove(arr[i]);
                }
            }else{
                return false;
            }
        }
        return true;
    }
}