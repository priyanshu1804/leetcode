class Solution {
    public int solve(int[][] items,int target){
        int low=0;
        int high=items.length-1;
        int max=0;
        while(low<=high){
            int mid=(high+low)/2;
            if(items[mid][0]>target){
                high=mid-1;
            }else{
                max=Math.max(max,items[mid][1]);
                low=mid+1;
            }
        }
        return max;
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] ans=new int[queries.length];
        Arrays.sort(items,Comparator.comparingInt(a->a[0]));
        int max=Integer.MIN_VALUE;
        for(int i=0;i<items.length;i++){
            max=Math.max(max,items[i][1]);
            items[i][1]=max;
        }
        for(int i=0;i<queries.length;i++){
            ans[i]=solve(items,queries[i]);
        }
        return ans;
    }
}