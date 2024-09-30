class CustomStack {

    Node head;
    int current_size;
    int max_size;

    private static class Node {
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    public CustomStack(int max_size) {
        this.max_size = max_size;
    }
    
    public void push(int x) {
        if(current_size == max_size)
            return;

        Node node = new Node(x);
        node.next = head;
        head = node;
        current_size++;
    }
    
    public int pop() {
        if(current_size == 0)
            return -1;

        int ans = head.val;
        head = head.next;
        current_size--;
        return ans;
    }
    
    public void increment(int k, int val) {
        if(current_size == 0 || val == 0)
            return;
        if(k > current_size)    k=current_size;

        int skipCount = current_size - k;
        Node temp = head;
        for(int i=0; i<skipCount; i++)
            temp = temp.next;
        
        while(temp != null){
            temp.val = temp.val + val;
            temp = temp.next;
        }
    }
}