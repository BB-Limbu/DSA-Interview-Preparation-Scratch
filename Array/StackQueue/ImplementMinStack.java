

public class ImplementMinStack {
    /*
    Implement minimum Stack
    Time Complexity O(1)
    Space Complexity O(n)
     */
    static class MinStack{
        private Stack<int[]> st;

        public MinStack() {
            st = new Stack<>();
        }
        public void push(int val){
            if(st.isEmpty()){
                // Push current value as minimum
                st.push(new int[] {val, val});
                return;
            }

            //update the current minimum
            int min = Math.min(getMin(), val);

            //Add pair to the stack

            st.push(new int[] {val, min});
        }

        public void pop(){
            st.pop();
        }
        public int top(){
            return st.peek()[0];
        }

        public int getMin(){
            return st.peek()[1];
        }
    }
/*
Optimal Approach
Time Complexity O(1)
Space Complexity O(n)
 */

    static class minStack{
        private Stack<Integer> st;
        private int mini;


        public minStack(){
            st = new Stack<>();
        }

        public void push(int val){
            if(st.isEmpty()){
                mini = val;
                st.push(val);
                return;
            }

            if(val > mini){
                st.push(val);
            }else{
                st.push(2 * val -mini);
                mini = val;
            }
        }

        public void pop(){
            if(st.isEmpty()) return;
            int x = st.pop();

            if(x < mini){
                mini = 2 * mini - x;
            }
        }

        public int top(){
            if(st.isEmpty()) return -1;
            int x = st.peek();

            if(mini < x) return x;
            return mini;
        }

        public int getMin(){
            return mini;
        }
    }

    public static void main(String[] args){
        minStack s = new minStack();

        // Function calls
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.print(s.getMin() + " ");
        s.pop();
        System.out.print(s.top() + " ");
        s.pop();
        System.out.print(s.getMin());
    }
}

