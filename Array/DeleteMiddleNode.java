
public class DeleteMiddleNode {
    /*
    Q.Delete middle Node
    Better force Approach
    Time Complexity O(n+n/2)
    Space Complexity O(1)
     */
    public static ListNode_4 deleteMiddleNode(ListNode_4 head){
        ListNode_4 temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        int res = count/2;
        temp = head;
        while(temp != null){
            res--;
            if(res == 0){
                ListNode_4 middle = temp.next;
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    /*
    Optimal Approach
    Time Complexity O(n/2)
    Space Complexity O(1)
     */
    public static ListNode_4 deleteMiddle_Node(ListNode_4 head){
        if(head == null || head.next == null){
            return null;
        }
        ListNode_4 slow = head, fast = head;
        fast = fast.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            head = head.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
