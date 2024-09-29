class AllOne{
    class Entry{
        int count;
        String key;
        public Entry(String key){
            this.key=key;
            count=1;
        }
    }
    HashMap<String,Entry> entries; 
    PriorityQueue<Entry> maxHeap;
    PriorityQueue<Entry> minHeap;
    public AllOne(){
        entries=new HashMap();
        maxHeap=new PriorityQueue(new Comparator<Entry>(){
            public int compare(Entry a,Entry b){
                return Integer.compare(b.count,a.count);
            }
        });
        minHeap=new PriorityQueue(new Comparator<Entry>(){
            public int compare(Entry a,Entry b){
                return Integer.compare(a.count,b.count);
            }
        });
    }
    public void inc(String key){
        Entry e;
        if(entries.containsKey(key)){
            e=entries.get(key);
            e.count++;
            maxHeap.remove(e);
            minHeap.remove(e);
        }    
        else{
            e=new Entry(key);
            entries.put(key,e);
        }
        minHeap.add(e);
        maxHeap.add(e);
    }
    public void dec(String key){
        Entry e;
        if(entries.containsKey(key)){
            e=entries.get(key);
            e.count--;
            maxHeap.remove(e);
            minHeap.remove(e);
            if(e.count==0){
                entries.remove(e);    
            }
            else{
                minHeap.add(e);
                maxHeap.add(e);   
            }
        }
    }
    public String getMaxKey() {
        if(maxHeap.size()==0){
            return "";
        }
        else{
            return maxHeap.peek().key;
        }
    }
    public String getMinKey() {
        if(minHeap.size()==0){
            return "";
        }
        else{
            return minHeap.peek().key; 
        }   
    }
}