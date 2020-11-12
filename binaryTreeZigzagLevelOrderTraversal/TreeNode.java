package binaryTreeZigzagLevelOrderTraversal;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    List res=new LinkedList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root!=null) backtrace(0, root);
        return res;
    }
    private void backtrace(int level, TreeNode node){
        if(level>=res.size()) res.add(new LinkedList<>());
        List l=(List)res.get(level);

        if(level%2==0) l.add(l.size(), node.val);
        else l.add(0, node.val);

        if(node.left!=null) backtrace(level+1, node.left);
        if(node.right!=null) backtrace(level+1, node.right);
    }
}