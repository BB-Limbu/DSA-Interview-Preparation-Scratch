

public static ListNode_5 sortLinkedList(ListNode_5 head){
    ArrayList<Integer> arr = new ArrayList<>();
    ListNode_5 temp = head;
    while(temp != null){
        arr.add(temp.data);
        temp = temp.next;
    }
    Collections.sort(arr);
    for(int i = 0; i < arr.size(); i++){
        temp.data = arr.get(i);
        temp = temp.next;
    }
    return head;
}
