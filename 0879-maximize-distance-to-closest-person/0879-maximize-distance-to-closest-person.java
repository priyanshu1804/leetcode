class Solution {
    public int maxDistToClosest(int[] seats) {
        int n=seats.length;
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(seats[i]==1){
                arr.add(i);
            }
        }
        System.out.println(arr);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.size()-1;i++){
            int x=arr.get(i);
            int y=arr.get(i+1);
            max=Math.max(max,(y-x)/2);
        }
        max=Math.max(max,((seats.length-1)-arr.get(arr.size()-1)));
        max=Math.max(max,(arr.get(0)-0));
        return max;
    }
}