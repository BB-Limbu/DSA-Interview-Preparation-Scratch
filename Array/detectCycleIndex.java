import java.util.*;
public class detectCycleIndex {
    /*
    Q. detect Cycle first element  and return index of that element;
    Better Approach
    Time Complexity O(n)
    Space Complexity O(n)
     */
    public static Listnode detectCycleIndex(Listnode head){
        Set<Listnode> visit = new HashSet<>();
        Listnode temp = head;
        while(temp != null){
            if(visit.contains(temp)){
                return head;
            }
            visit.add(temp);
            head = head.next;
        }
        return null;
    }
    /*
    Optimal Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */

    public static Listnode detectCycleIdx(Listnode head){
        Listnode slow = head;
        Listnode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    public static void main(String[] args){

    }
}

