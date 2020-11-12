package validBinarySearchTree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    public static void main(String[] args){
        System.out.println("valid binary search tree");
        test();
    }
    public static void test(){
        TreeNode n1=new TreeNode(5);
        n1.left=new TreeNode(1);
        n1.right=new TreeNode(4);
        n1.right.left=new TreeNode(3);
        n1.right.right=new TreeNode(6);
        System.out.println(new Solution().isValidBST(n1));
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    private boolean isValid(TreeNode node, Integer min, Integer max){
        boolean b=true;
        if(node==null) return true;
        if(min!=null&&node.val<=min) return false;
        if(max!=null&&node.val>=max) return false;
        if(!isValid(node.left, min, node.val)) return false;
        if(!isValid(node.right, node.val, max)) return false;
        return true;
    }
}