package StackQueue;



public class ImplementQueueUsingArray {
    static class ArrayQueue{
        int[] arr;
        int start, end;
        int curr_size;
        int max_size;


        public ArrayQueue(){
            arr = new int[10];
            start = -1;
            end = -1;
            curr_size = 0;
            max_size = 0;
        }

        public void push(int x){
            if(curr_size == max_size){
                System.out.println("Queue is full");
                System.exit(1);
            }
            if(end == -1){
                start = 0;
                end = 0;
            }else{
                end = (end + 1) % max_size;
            }
            arr[end]  = x;
            curr_size++;
        }

        public int pop(){
            if(start == -1){
                System.out.println("Queue Empty");
                System.exit(1);
            }
            int popped = arr[start];
            if(curr_size == 1){
                start = -1;
                end = -1;
            }else{
                start = (start + 1) % max_size;
            }
            curr_size--;
            return popped;
        }
        public int peek(){
            if(start == -1){
                System.out.println("Queue Empty");
                System.exit(1);
            }
            return arr[start];
        }
        public boolean isEmpty(){
            return curr_size == 0;
        }
    }
}
