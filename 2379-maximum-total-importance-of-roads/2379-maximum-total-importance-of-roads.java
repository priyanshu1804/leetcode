class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] indegree=new long[n];
        for(int i=0;i<roads.length;i++){
            indegree[roads[i][0]]++;
            indegree[roads[i][1]]++;
        }
        Arrays.sort(indegree);
        long value=1;
        long sum=0;
        for(long it:indegree){
            sum+=value*it;
            value++;
        }
        return sum;
    }
}