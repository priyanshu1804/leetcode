class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(c1,c2)->Integer.compare(c1[1],c2[1]));
        PriorityQueue<Integer> pq=new PriorityQueue<>((d1,d2)->Integer.compare(d2,d1));
        int time=0;
        for(int[] it:courses){
            int duration=it[0];
            int last=it[1];
            time+=duration;
            pq.add(duration);
            if(time>last){
                time-=pq.poll();
            }
        }
        return pq.size();
    }
}