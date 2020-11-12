package symmetricTree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    public static void main(String[] args){
        //
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return backtrace(root, root);
    }
    private boolean backtrace(TreeNode node1, TreeNode node2){
        if(node1==null&&node2==null) return true;
        if(node1!=null&&node2!=null) return 
        node1.val==node2.val&&backtrace(node1.left, node2.right)&&backtrace(node1.right, node2.left);
        else return false;
    }
}