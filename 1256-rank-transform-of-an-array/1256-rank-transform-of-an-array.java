class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] nums=Arrays.stream(arr).distinct().sorted().toArray();
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],i+1));
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}