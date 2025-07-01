class Pair{
    String trimmed;
    int index;
    Pair(String t,int i){
        trimmed=t;
        index=i;
    }
}
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] ans=new int[queries.length];
        int n=nums.length;
        for(int i=0;i<queries.length;i++){
            int k=queries[i][0];
            int trim=queries[i][1];
            PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{int cmp=a.trimmed.compareTo(b.trimmed);
            if (cmp != 0){
                return cmp;
            }
            return Integer.compare(a.index, b.index);
        });

            for(int j=0;j<n;j++){
                String trimmed=nums[j].substring(nums[j].length()-trim);
                pq.add(new Pair(trimmed,j));
            }
            for(int j=1;j<k;j++){
                pq.poll();
            }
            ans[i]=pq.peek().index;
        }
        return ans;
    }
}