
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    int res=0;
    public int maxDepth(TreeNode root) {
        if(root==null) return res;
        traverse(0, root);
        return res;
    }
    public void traverse(Integer level, TreeNode node){
        level++;
        if(level>res) res=level;
        if(node.left!=null) traverse(level, node.left);
        if(node.right!=null) traverse(level, node.right);
        level--;
    }
}