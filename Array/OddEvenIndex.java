

import java.util.*;
class ListNode_2{
    int data;
    ListNode_2 next;

    ListNode_2(int data1, ListNode_2 next1){
        this.data = data1;
        this.next = next1;
    }
    ListNode_2(int data1){
        this.data = data1;
        this.next = null;
    }
};

public class OddEvenIndex {
    /*
    Q. Arrange odd and even node base on  even and odd index
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public static ListNode_2 OrderOddEvenIdx(ListNode_2 head){
        List<Integer> arr = new ArrayList<>();
        ListNode_2 temp = head;
        while(temp != null && temp.next != null){
            arr.add(temp.data);
            temp = temp.next.next;
        }
        if(temp != null){
            arr.add(temp.data);
        }
        temp = head.next;

        while(temp != null && temp.next != null){
            arr.add(temp.data);
            temp = temp.next;
        }
        if(temp != null){
            arr.add(temp.data);
        }
        int i = 0;
        temp = head;
        while(temp != null){
            temp.data = arr.get(i);
            i++;
            temp = temp.next;
        }
        return head;
    }
    /*
    Optimal Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */

    public static ListNode_2 arrageOddEvenIdx(ListNode_2 head){
        if(head == null || head.next == head){
            return head;
        }
        ListNode_2 odd = head,  even = head.next , newHead = head.next;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even = even.next.next;
            even = even.next;
        }
        odd.next =newHead;
        return head;
    }
    public static void main(String[] args){

    }
}

