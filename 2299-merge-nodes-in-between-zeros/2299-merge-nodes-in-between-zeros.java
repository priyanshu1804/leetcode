/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode newNode=new ListNode(0);
        ListNode temp=newNode;
        int count=0;
        ListNode curr=head;
        int ans=0;
        while(curr!=null){
            if(curr.val==0){
                count++;
            }else{
                ans+=curr.val;
            }
            if(count==2){
                ListNode Node=new ListNode(ans);
                temp.next=Node;
                temp=temp.next;
                ans=0;
                count=1;
            }
            curr=curr.next;
        }
        return newNode.next;
    }
}