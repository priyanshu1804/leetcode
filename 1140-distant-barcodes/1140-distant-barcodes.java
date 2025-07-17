class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n=barcodes.length;
        HashSet<Integer> set=new HashSet<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(int i=0;i<n;i++){
            set.add(barcodes[i]);
            map.put(barcodes[i],map.getOrDefault(barcodes[i],0)+1);
        }
        for(int it:set) {
            pq.add(it);
        }
        int i=0;
        while(!pq.isEmpty()){
            int x=pq.remove();
            int y=-1;
            if(!pq.isEmpty()){
                y=pq.remove();
            }
            barcodes[i++]=x;
            if(y!=-1){
                barcodes[i++]=y;
            }
            map.put(x,map.get(x)-1);
            if(map.get(x)>0){
                pq.add(x);
            }
            if(y!=-1){
                map.put(y,map.get(y)-1);
                if(map.get(y)>0){
                    pq.add(y);
                }
            }
        }
        return barcodes;
    }
}
