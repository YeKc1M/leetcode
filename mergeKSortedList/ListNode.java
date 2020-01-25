import java.util.Arrays;

public class ListNode{
    int val;
    ListNode next;
    public ListNode(int v){val=v;}
}

class Solution {
    //normal solution: 2-way merge
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        int length=lists.length;
        return mergeTwo(Arrays.copyOfRange(lists, 0, length/2), Arrays.copyOfRange(lists, length/2, length));
    }
    private ListNode mergeTwo(ListNode[] list1, ListNode[] list2){
        if(list1.length==0) return list2[0];
        if(list2.length==0) return list1[0];
        if(list1.length==1&&list2.length==1){
            //merge 2
            return mergeTwoLists(list1[0], list2[0]);
        }else{
            //
            ListNode l1=mergeTwo(
                Arrays.copyOfRange(list1, 0, list1.length/2), Arrays.copyOfRange(list1, list1.length/2, list1.length)
            );
            ListNode l2=mergeTwo(
                Arrays.copyOfRange(list2, 0, list2.length/2), Arrays.copyOfRange(list2, list2.length/2, list2.length)
            );
            return mergeTwoLists(l1,l2);
        }
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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