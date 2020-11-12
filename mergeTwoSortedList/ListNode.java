package mergeTwoSortedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first=new ListNode(0),l=first,f1=l1,f2=l2;
        while(f1!=null&&f2!=null){
            int i1=f1.val,i2=f2.val;
            if(i1<i2){
                l.next=new ListNode(i1);
                l=l.next;
                f1=f1.next;
            }else{
                l.next=new ListNode(i2);
                l=l.next;
                f2=f2.next;
            }
        }
        if(f1==null){
            while(f2!=null){
                l.next=new ListNode(f2.val);
                l=l.next;
                f2=f2.next;
            }
        }
        if(f2==null){
            while(f1!=null){
                l.next=new ListNode(f1.val);
                l=l.next;
                f1=f1.next;
            }
        }
        return first.next;
    }
}