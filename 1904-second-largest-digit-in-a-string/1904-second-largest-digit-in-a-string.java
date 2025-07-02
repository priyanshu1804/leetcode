class Solution {
    public int secondHighest(String s) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)&&!pq.contains(ch-'0')){
                pq.add(ch-'0');
            }
        }
        if(pq.size()==1||pq.isEmpty()){
            return -1;
        }
        pq.remove();
        return pq.remove();
    }
}