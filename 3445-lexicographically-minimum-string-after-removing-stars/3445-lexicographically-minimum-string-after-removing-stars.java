class pair{
    char first;
    int second;
    public pair(char first, int second){
        this.first=first;
        this.second=second;
    }
}
class Solution{
    public String clearStars(String s){
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.first!=b.first?a.first-b.first:b.second-a.second);
        HashSet<Integer> set=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch!='*'){
                pq.add(new pair(ch,i));
            }else if(!pq.isEmpty()){
                pair x=pq.poll();
                set.add(x.second);
            }
        }
        for(int i=0;i<s.length();i++){
            if(!set.contains(i)&&s.charAt(i)!='*'){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
