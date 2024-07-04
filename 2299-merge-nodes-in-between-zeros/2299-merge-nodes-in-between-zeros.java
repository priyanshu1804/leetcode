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
        ListNode newNode=new ListNode();
        int count=0;
        int ans=0;
        ListNode temp=newNode;
        ListNode curr=head;
        while(curr!=null){
            if(curr.val==0){
                count++;
            }else{
                ans+=curr.val;
            }
            if(count==2){
                ListNode node=new ListNode(ans);
                temp.next=node;
                temp=temp.next;
                count=1;
                ans=0;
            }
            curr=curr.next;
        }
        return newNode.next;
    }
}