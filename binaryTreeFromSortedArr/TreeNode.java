package binaryTreeFromSortedArr;

import java.util.Arrays;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root=null;
        if(nums.length!=0){
            if(nums.length==1){
                root=new TreeNode(nums[0]);
            }else{
                int n=nums.length;
                root=new TreeNode(nums[n/2]);
                root.left=sortedArrayToBST(Arrays.copyOfRange(nums, 0, n/2));
                root.right=sortedArrayToBST(Arrays.copyOfRange(nums, n/2+1, n));
            }
        }
        return root;
    }
}