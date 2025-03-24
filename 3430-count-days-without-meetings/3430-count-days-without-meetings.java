class Solution {
    public int countDays(int days, int[][] meetings) {
        int ans=0;
        int prev=0;
        Arrays.sort(meetings,Comparator.comparingInt(a->a[0]));
        for(int[] it:meetings){
            int start=it[0];
            int end=it[1];
            if(start>prev+1){
                ans+=start-prev-1;
            }
            prev=Math.max(end,prev);
        }
        ans+=days-prev;
        return ans;
    }
}