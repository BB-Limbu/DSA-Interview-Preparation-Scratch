
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode newNode = new ListNode(0);
        newNode.next = head;

        ListNode prev = newNode;

        while(prev.next != null && prev.next.next != null){
            ListNode start = prev.next;
            ListNode end = start.next;

            start.next = end.next;
            end.next = start;
            prev.next = end;

            prev = start;
        }

        return newNode.next;
    }
}
