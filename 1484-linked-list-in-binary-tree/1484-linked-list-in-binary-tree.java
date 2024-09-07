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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean solve(ListNode head,TreeNode root){
        if(head==null){
            return true;
        }
        if(root==null){
            return false;
        }
        boolean ans=false;
        if(root.val==head.val){
            ans=solve(head.next,root.left);
            ans=ans||solve(head.next,root.right);
        }
        return ans;
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null){
            return false;
        }
        boolean ans=solve(head,root);
        ans=ans||isSubPath(head,root.left);
        ans=ans||isSubPath(head,root.right);
        return ans;
    }
}