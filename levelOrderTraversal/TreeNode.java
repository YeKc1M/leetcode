import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    //normal solution
    public List<List<Integer>> levelOrder(TreeNode root) {
        List queue1=new LinkedList<>(),queue2=new LinkedList<>();
        List res=new LinkedList<>();
        TreeNode temp=root;
        if(temp!=null){
            queue1.add(temp);
            List element=new LinkedList<>();
            while(!queue1.isEmpty()){
                Iterator itr=queue1.iterator();
                while(itr.hasNext()){
                    temp=(TreeNode)itr.next();
                    element.add(temp.val);
                    if(temp.left!=null) queue2.add(temp.left);
                    if(temp.right!=null) queue2.add(temp.right);
                }
                res.add(element);
                element=new LinkedList<>();
                queue1=queue2;
                queue2=new LinkedList<>();
            }
        }
        return res;
    }
}