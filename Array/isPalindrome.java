public boolean isPalindrome(Node head){
    if(head == null || head.next == null){
        return true;
    }
    Node midNode = findMidNode(head);


    Node prev = null;
    Node temp = midNode;
    Node next;

    while(temp != null){
        next = temp.next;
        temp.next = prev;
        prev = temp;
        temp = next;
    }
    Node right = prev;
    Node left = head;
    while(right != null){
        if(left.data != right.data){
            return false;
        }
    }
    return true;
}
