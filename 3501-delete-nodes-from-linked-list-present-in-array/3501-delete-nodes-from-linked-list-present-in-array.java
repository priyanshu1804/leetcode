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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set=new HashSet<>();
        ListNode curr=head;
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        while(curr!=null){
            if(!set.contains(curr.val)){
                temp.next=new ListNode(curr.val);
                temp=temp.next;
            }
            curr=curr.next;
        }
        return dummy.next;
    }
}