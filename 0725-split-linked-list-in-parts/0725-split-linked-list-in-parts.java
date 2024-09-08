class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr=head;
        ListNode[] p=new ListNode[k];
        int n=0;
        while(curr!=null){
            n++;
            curr=curr.next;
        }
        int len=n/k;
        int a=n%k;
        ListNode prev=head;
        ListNode temp=null;
        int i=0;
        while(prev!=null&&i<k){
            p[i]=prev;
            if(a>0){
                for(int j=0;j<len+1;j++){
                    temp=prev;
                    prev=prev.next;
                }
            }
            else{
                for(int j=0;j<len;j++){
                    temp=prev;
                    prev=prev.next;
                }
            }
            temp.next=null;
            i++;
            a--;
        }
        return p;
    }
}