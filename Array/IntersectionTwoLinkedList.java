

public class IntersectionTwoLinkedList {
    public static ListNode_7 intersection_TwoLL(ListNode_7 head1, ListNode_7 head2){

        Set<ListNode_7>  st = new HashSet<>();
        ListNode_7 temp = head1;
        while(temp != null){
            st.add(head1);
            temp = temp.next;
        }
        while(head2 != null){
            if(st.contains(head2)){
                return head2;
            }
            head2 = head2.next;
        }
        return null;
    }
    public static ListNode_7 intersectionTwoLL(ListNode_7 head1, ListNode_7 head2){
        if(head1 == null || head2 == null){
            return null;
        }
        ListNode_7 temp1 = head1;
        ListNode_7 temp2 = head2;

        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if(temp1 == temp2){
            return temp1;
        }
        if(temp1 == null){
            temp1 = head2;
        }
        if(temp2 == null){
            temp2 = head1;
        }
        return temp1;
    }
    /*Optimized code
    public static ListNode_7 intersection(ListNode_7 head1, ListNode_7 head2){
        if(head1 == null || head2 == null){
            return null;
        }
        ListNode_7 temp1 = head1;
        ListNode_7 temp2 = head2;

        while(temp1 != temp2){
            temp1 = (temp1 == null) ? head2 : temp1.next;
            temp2 = (temp2 == null) ? head1 : temp2.next;
        }
        return temp2;
    }
    public static void main(String[] args){

    }
}

