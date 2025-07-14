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
    public int getDecimalValue(ListNode head) {
        ListNode curr=head;
        ListNode temp=head;
        int n=-1;
        int sum=0;
        while(curr!=null){
            n++;
            curr=curr.next;
        }
        while(temp!=null){
            sum+=temp.val*(Math.pow(2,n--));
            temp=temp.next;
        }
        return sum;
    }
}