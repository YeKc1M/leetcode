package binaryTreeMaxPathsum;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    public static void main(String[] args){
        /*
        TreeNode root=new TreeNode(-10);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);*/
        /*
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(-1);*/
        TreeNode root=new TreeNode(9);//9 6 -3 null null -6 2 null null 2 null -6 -6 -6
        root.left=new TreeNode(6);root.right=new TreeNode(-3);
        root.right.left=new TreeNode(-6);root.right.right=new TreeNode(2);
        root.right.right.left=new TreeNode(2);
        root.right.right.left.left=new TreeNode(-6);root.right.right.left.right=new TreeNode(-6);
        root.right.right.left.left.left=new TreeNode(-6);
        //System.out.println(new Solution().maxPathSum(root));
    }
}

class Solution {
    /*
    public int maxPathSum(TreeNode root) {
        int res=0;
        if(root!=null){
            if(root.left==null&&root.right==null) return root.val;
            int lmax=0, rmax=0;
            int max=0;
            if(root.left!=null){
                lmax=maxPathSum(root.left);
            }else{
                lmax=Integer.MIN_VALUE;
            }
            if(root.right!=null){
                rmax=maxPathSum(root.right);
            }else{
                rmax=Integer.MIN_VALUE;
            }
            max=countMax(root);
            res=Math.max(Math.max(lmax, rmax), max);
        }
        return res;
    }
    private Integer countMax(TreeNode root){
        if(root==null) return 0;
        int res=0;
        int lmax=0,rmax=0;
        lmax=countPath(root.left);
        rmax=countPath(root.right);
        res=Math.max(lmax, 0)+Math.max(rmax,0)+root.val;
        return res;
    }
    private Integer countPath(TreeNode root){
        if(root==null) return 0;
        int lmax=countPath(root.left), rmax=countPath(root.right);
        return Math.max(lmax, rmax)+root.val;
    }*/
    int max_sum = Integer.MIN_VALUE;

  public int max_gain(TreeNode node) {
    if (node == null) return 0;

    // max sum on the left and right sub-trees of node
    int left_gain = Math.max(max_gain(node.left), 0);
    int right_gain = Math.max(max_gain(node.right), 0);

    // the price to start a new path where `node` is a highest node
    int price_newpath = node.val + left_gain + right_gain;

    // update max_sum if it's better to start a new path
    max_sum = Math.max(max_sum, price_newpath);

    // for recursion :
    // return the max gain if continue the same path
    return node.val + Math.max(left_gain, right_gain);
  }

  public int maxPathSum(TreeNode root) {
    max_gain(root);
    return max_sum;
  }
}