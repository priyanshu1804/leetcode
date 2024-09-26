class MyCalendar {
    private List<int[]> arr;
    public MyCalendar() {
        this.arr=new ArrayList<>();
    }
    public boolean book(int start, int end) {
        for(int[] it:arr){
            int start1=it[0];
            int end1=it[1];
            if(!(end<=start1||start>=end1)){
                return false;
            }
        }   
        arr.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */