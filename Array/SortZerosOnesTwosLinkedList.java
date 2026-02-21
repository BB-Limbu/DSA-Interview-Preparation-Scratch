
public class SortZerosOnesTwosLinkedList {
    public static ListNode_6 sortZeroOneTwo(ListNode_6 head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode_6 temp = head;
        int count = 0, countOne = 0, countTwo = 0;
        while(temp != null){
            if(temp.data == 0){
                count++;
            }
            else if(temp.data == 1){
                countOne++;
            }
            else{
                countTwo++;
            }
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            if(count != 0){
                temp.data = 0;
                count--;
            }
            else if(countOne != 0){
                temp.data = 1;
                countOne--;
            }
            else {
                temp.data = 2;
                countTwo--;
            }
            temp = temp.next;
        }
        return head;
    }
    public static ListNode_6 sortZeroOneTwos(ListNode_6 head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode_6 zeroHead = new ListNode_6(-1);
        ListNode_6 oneHead = new ListNode_6(-1);
        ListNode_6 twoHead= new ListNode_6(-1);

        ListNode_6 zero = zeroHead;
        ListNode_6 one = oneHead;
        ListNode_6 two = twoHead;

        ListNode_6 temp = head;
        while(temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.data == 1){
                one.next = temp;
                one = one.next;
            }
            else{
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        zero.next = (zeroHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;
        ListNode_6 newHead = zeroHead.next;
        return newHead;

    }
}

