class Solution {
    public int minGroups(int[][] intervals) {
        List<int[]> ans=new ArrayList<>();
        for(int[] interval:intervals){
            ans.add(new int[]{interval[0],1});
            ans.add(new int[]{interval[1]+1,-1});
        }
        Collections.sort(ans,(a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(a[1],b[1]);
            }else{
                return Integer.compare(a[0],b[0]);
            }
        });
        int max=0;
        int curr=0;
        for(int[] it:ans){
            curr+=it[1];
            max=Math.max(max,curr);
        }
        return max;
    }
}