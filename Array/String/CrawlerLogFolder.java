
public class CrawlerLogFolder {
    public static int minOperation(String[] logs){
        Stack<String> st = new Stack<>();

        for(String log : logs){
            if(log.equals("../")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else if(!log.equals("./")){
                st.push(log);

            }

        }
        return st.size();
    }
}
