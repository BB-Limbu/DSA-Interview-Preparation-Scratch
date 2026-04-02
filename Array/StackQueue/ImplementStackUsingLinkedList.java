


public class ImplementStackUsingLinkedList {
    static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
            this.next =  null;
        }
    }
    /*
    Optimal Approach
    Time Complexity O(1)
    Space Complexity O(n)
     */

    static class LinkedListStack{
        private Node head;
        private int size;

        public LinkedListStack(){
            head = null;
            size = 0;
        }

        public void push(int x){
            Node element = new Node(x);
            element.next = head;
            head = element;
            size++;
        }
        public int pop(){
            if(head == null){
                return -1;
            }
            int val = head.val; // Gert the top value
            Node temp = head; // store the top temporary
            head = head.next; //update top to nextNode
            temp = null; //Delete old top node
            size--; // Decrement size
            return val; //Return data
        }
        public int top(){
            if(head == null){
                return -1;
            }
            return head.val;
        }

        public boolean isEmpty(){
            return (size == 0);
        }
    }
}

