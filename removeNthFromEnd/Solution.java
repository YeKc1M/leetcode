public class Solution {
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
    public static void main(String[] args){
        System.out.println("remove nth from end");
        test();
    }
    public static void test(){
        new Solution().removeNthFromEnd(new ListNode(1), 1);
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
