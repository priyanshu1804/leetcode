class Solution {
    public int findLucky(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int ans=-1;
        for(int i=0;i<n;i++){
            int val=map.getOrDefault(arr[i],0);
            if(val==arr[i]){
                ans=arr[i];
            }
        }
        return ans;
    }
}