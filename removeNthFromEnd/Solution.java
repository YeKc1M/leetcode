package removeNthFromEnd;

public class Solution {
    //normal solution
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int length=0;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        temp=head;
        if(n==length){
            head=head.next;
            return head;
        }
        for(int i=0;i<length-n-1;i++){
            temp=temp.next;
        }
        if(temp.next!=null){
            temp.next=temp.next.next;
        }else{
            temp.next=null;
        }
        return head;
    }
    //double pointer
    public ListNode removeNthFromEnd1(ListNode head, int n){
        ListNode first=new ListNode(0);
        first.next=head;
        ListNode l1=head,l2=first;
        for(int i=0;i<n;i++){
            l1=l1.next;
        }
        while(l1!=null){
            l1=l1.next;
            l2=l2.next;
        }
        if(l2.next!=null){
            l2.next=l2.next.next;
        }else{
            l2.next=null;
        }
        return first.next;
    }
    public static void main(String[] args){
        System.out.println("remove nth from end");
        //test1();
        test2();
    }
    public static void test1(){
        new Solution().removeNthFromEnd(new ListNode(1), 1);
    }
    public static void test2(){
        new Solution().removeNthFromEnd1(new ListNode(1), 1);
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
