package CountCompleteTreeNodes;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static void main(String[] args){
        System.out.println("hello world!");
        int i=6;
        System.out.println(1<<i);
        System.out.println(1>>i);
        System.out.println(i>>1);
        System.out.println(i<<1);
    }
}


class Solution {
    //my solution
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    //https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/chang-gui-jie-fa-he-ji-bai-100de-javajie-fa-by-xia/
    public int countNodes1(TreeNode root) {
        if(root == null){
           return 0;
        } 
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        /* 
         * 
         * 
         * 
         */ 
        if(left == right){
            return countNodes(root.right) + (1<<left);
        }else{
            return countNodes(root.left) + (1<<right);
        }
    }
    private int countLevel(TreeNode root){
        int level = 0;
        while(root != null){
            level++;
            root = root.left;
        }
        return level;
    }
}
