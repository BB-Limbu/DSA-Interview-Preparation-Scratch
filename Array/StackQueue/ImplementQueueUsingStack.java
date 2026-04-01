

public class ImplementQueueUsingStack {
    static class StackQueue{
        Stack<Integer> input, output;

        public StackQueue(){
            input = new Stack<>();
            output = new Stack<>();
        }

        public  void push(int x){
            input.push(x);
        }

        public int pop(){
            if(output.isEmpty()){
                while(!input.isEmpty()){
                    output.push(input.pop());
                }
            }

            if(output.isEmpty()){
                System.out.println("Queue Empty");
                return -1;
            }
            return output.pop();
        }

        public int peek(){
            if(output.isEmpty()){
                while(!input.isEmpty()){
                    output.push(input.pop());
                }
            }
            if(output.isEmpty()){
                System.out.println("Queue Empty");
                return -1;
            }
            return output.pop();
        }
        public boolean isEmpty(){
            return input.isEmpty() && output.isEmpty();
        }
    }
}

