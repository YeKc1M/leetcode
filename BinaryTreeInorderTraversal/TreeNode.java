import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; } 
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List l=new LinkedList<>();
        if(root!=null) inorder(l, root);
        return l;
    }
    private void inorder(List l, TreeNode node){
        if(node.left!=null) inorder(l, node.left);
        l.add(node.val);
        if(node.right!=null) inorder(l, node.right);
    }
    public List<Integer> inorderTraversal1(TreeNode root){
        List res = new LinkedList<>();
        Stack stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = (TreeNode)stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}