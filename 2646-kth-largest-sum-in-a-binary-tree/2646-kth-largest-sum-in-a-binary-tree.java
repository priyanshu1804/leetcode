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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q=new LinkedList<>();
        PriorityQueue<Long> pq=new PriorityQueue<>(Comparator.reverseOrder());
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            long sum=0;
            while(size>0){
                TreeNode node=q.poll();
                sum+=(long)node.val;
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                size--;
            }
            pq.add(sum);
        }
        long ans=-1;
        if(k>pq.size()){
            return -1;
        }
        while(k-->0&&!pq.isEmpty()){
            ans=pq.poll();
        }
        return ans;
    }
}