class Solution {
    class pair{
        int alice;
        int bob;
        public pair(int alice,int bob){
            this.alice=alice;
            this.bob=bob;
        }
    }
    class pair1 implements Comparator<pair>{
        @Override
        public int compare(pair o1,pair o2){
            return (o2.alice+o2.bob)-(o1.alice+o1.bob);
        }
    }
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<pair> pq=new PriorityQueue<>(new pair1());
        for(int i=0;i<aliceValues.length;i++){
            pq.add(new pair(aliceValues[i],bobValues[i]));
        }
        int j=0;
        int x=0;
        int y=0;
        while(!pq.isEmpty()){
            pair it=pq.poll();
            if(j%2==0){
                x+=it.alice;
            }else{
                y+=it.bob;
            }
            j++;
        }
        if(x>y){
            return 1;
        }else if(x==y){
            return 0;
        }else{
            return -1;
        }
    }
}