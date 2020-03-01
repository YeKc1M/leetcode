import java.util.Arrays;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root=null;
        if(preorder.length!=0){
            int n=preorder.length;
            int pre=preorder[0], in=inorder[0];
            root=new TreeNode(pre);
            int index=0;
            for(;index<n;index++){
                if(inorder[index]==pre) break;
            }
            root.left=buildTree(Arrays.copyOfRange(preorder, 1, 1+index),Arrays.copyOfRange(inorder, 0, index));
            root.right=buildTree(Arrays.copyOfRange(preorder, 1+index, n), Arrays.copyOfRange(inorder, index+1, n));
        }
        return root;
    }
}