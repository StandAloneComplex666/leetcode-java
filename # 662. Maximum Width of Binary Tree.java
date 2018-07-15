/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        map.put(root, 1);
        q.add(root);
        int max = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            int left = 0;
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                int index = map.get(curr);
                if(i == 0) {
                    left = index;
                }
                if(i == size - 1) {
                    max = Math.max(max, index - left + 1);
                }
                if(curr.left != null) {
                    map.put(curr.left, index * 2);
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    map.put(curr.right, index * 2 + 1);
                    q.add(curr.right);
                }
            }
        }
        return max;
    }
}