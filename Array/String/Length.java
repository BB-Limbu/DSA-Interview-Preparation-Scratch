
public class Length {
    public static int lenString(String str){
        if(str.length() == 0){
            return 0;
        }
        return lenString(str.substring(1)) + 1;
    }
    public static void main(String[] args){
        String str = "Helloworld";
        System.out.println(lenString(str));
    }
}


