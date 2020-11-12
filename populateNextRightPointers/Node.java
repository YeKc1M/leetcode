package populateNextRightPointers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
        Node temp=root;
        if(temp!=null){
            List l1=new LinkedList<>(),l2=new LinkedList<>();
            l1.add(temp);
            temp.next=null;
            while(!l1.isEmpty()){
                for(int i=0;i<l1.size();i++){
                    Node curr=(Node)l1.get(i);
                    if(curr.left!=null) l2.add(curr.left);
                    if(curr.right!=null) l2.add(curr.right);
                    if(i<l1.size()-1){
                        curr.next=(Node)l1.get(i+1);
                    }else{
                        curr.next=null;
                    }
                }
                l1=l2;
                l2=new LinkedList<>();
            }
        }
        return root;
    }
}