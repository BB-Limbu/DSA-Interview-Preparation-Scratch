
public class ReverseLinkedList {
    /*
    Brute Force Approach
     */
    public static ListNode reverseLinkedList(ListNode head){
        Stack<Integer> st = new Stack<>();
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        while(temp != null){
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            temp.data = st.pop();
            temp = temp.next;

        }
        return head;
    }
    /*
    Optimal Approach
     */

    public static ListNode reverse_LinkedList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode temp = head;
        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    /*
    Recursive Method
     */
    public static ListNode reverseLiked_List(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseLiked_List(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}
