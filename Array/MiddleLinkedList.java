
class node{
    int data;
    node next;
    node(int data1, node next1){
        this.data = data1;
        this.next = next1;
    }
    node(int data1){
        this.data = data1;
        this.next = null;
    }
};
public class MiddleLinkedList {
    public static void print(node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static node convertArr2DLL(int[] nums){
        node head = new node(nums[0]);
        node prev = head;

        for(int i = 1; i < nums.length; i++){
            node temp = new node(nums[i]);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
    public static node middleLinkedList(node head){
        int count = 0;
        node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        int midNode = count / 2 +1;
        temp = head;
        while(temp != null){
            midNode--;
            if(midNode == 0){
                break;
            }
            temp = temp.next;
        }
        return temp;
    }
    /*
    Optimal Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */

    public static node middle_LinkedList(node head){
        if(head == null || head.next == null){
            return head;
        }
        node slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

