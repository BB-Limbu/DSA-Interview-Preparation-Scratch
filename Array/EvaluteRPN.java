public class EvaluteRPN {
    public static int evaluteRPN(String[] tokens){
        Stack<Integer>  lifo = new Stack();
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int  a = lifo.pop();
                int b = lifo.pop();
                int res = -1;

                switch(token){
                    case "+" : res = a + b;
                    break;
                    case "-" : res = a - b;
                    break;
                    case "*" : res = a * b;
                    break;
                    case"/" : res = a /b;
                }
                lifo.push(res);
            }
            else{
                lifo.push(Integer.parseInt(token));
            }
        }
        return lifo.pop();
    }
}
