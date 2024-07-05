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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> ans=new ArrayList<>();
        int prev=head.val;
        int i=1;
        while(head!=null){
            int curr=head.val;
            if(head.next!=null){
                int next=head.next.val;
                if((prev>curr&&curr<next)||(prev<curr&&curr>next)){
                    ans.add(i);
                }
            }
            i++;
            prev=curr;
            head=head.next;
        }
        if(ans.size()<2){
            return new int[]{-1,-1};
        }
        int min=Integer.MAX_VALUE;
        int max=0;
        for(int j=0;j<ans.size()-1;j++){
            min=Math.min(min,ans.get(j+1)-ans.get(j));
        }
        max=ans.get(ans.size()-1)-ans.get(0);
        return new int[]{min,max};
    }
}