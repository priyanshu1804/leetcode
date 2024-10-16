class pair{
    int count;
    char ch;
    public pair(int count,char ch){
        this.count=count;
        this.ch=ch;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<pair> pq=new PriorityQueue<>((x,y)->y.count-x.count);
        if(a>0){
            pq.add(new pair(a,'a'));
        }
        if(b>0){
            pq.add(new pair(b,'b'));
        }
        if(c>0){
            pq.add(new pair(c,'c'));
        }
        String str="";
        while(!pq.isEmpty()){
            pair it=pq.remove();
            int count=it.count;
            char ch=it.ch;
            if(str.length()>=2&&str.charAt(str.length()-1)==ch&&str.charAt(str.length()-2)==ch){
                if(pq.isEmpty()){
                    break;
                }
                pair it1=pq.remove();
                str+=it1.ch;
                if(it1.count-1>0){
                    pq.add(new pair(it1.count-1,it1.ch));
                }
            }else{
                str+=it.ch;
                count--;
            }
            if(count>0){
                pq.add(new pair(count,ch));
            }
        }
        return str;
    }
}