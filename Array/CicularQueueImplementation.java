


public class CicularQueueImplementation {
    static class CircularQueue{
        static int[] arr;
        static int size;
        static int rear;
        static int front;

        CircularQueue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }
        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        public static boolean isFull(){
            return (rear + 1) % size == front;
        }
        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            if(front == -1){
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }
        //remove
        public  int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }

            int res = arr[front];

            //edge case: when Last element remove
            if(rear == front){
                rear = front = -1;
            }else{
                front = (front + 1) % size;
            }
            return res;
        }
        //Peek()
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue Empty");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String[] args){
        CircularQueue obj = new CircularQueue(3);
        obj.add(1);
        obj.add(2);
        obj.add(3);
        System.out.print(obj.remove()+" ");
        obj.add(4);
        System.out.print(obj.remove()+" ");
        obj.add(5);

        while(!obj.isEmpty()){
            System.out.print(obj.peek()+" ");
            obj.remove();
        }
    }
}

