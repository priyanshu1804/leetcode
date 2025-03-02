class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer> map=new TreeMap<>();
        for(int[] it:nums1){
            map.put(it[0],it[1]);
        }
        for(int[] it:nums2){
            map.put(it[0],map.getOrDefault(it[0],0)+it[1]);
        }
        List<int[]> arr=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
            arr.add(new int[]{entry.getKey(),entry.getValue()});
        }
        int[][] ans=new int[arr.size()][2];
        for(int i=0;i<arr.size();i++){
            ans[i]=arr.get(i);
        }
        return ans;
    }
}