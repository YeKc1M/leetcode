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
    //iteration 2-way merge
    public ListNode mergeKLists2(ListNode[] lists){
        int len = lists.length;
        if (len == 0) {
            return null;
        }    
        // 将n个链表以中间为对称，合并，即合并 
        while(len>1) {
            for (int i=0; i<len/2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[len-1-i]);
            }
            len = (len+1)/2;
        }
        return lists[0];
        /*
        作者：lin-jian-you-xue
        链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/luo-ji-fei-chang-jian-dan-de-javati-jie-shi-jian-j/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
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