public class  ExcelSheet{
    public static String converToTile(int s){
        StringBuilder res = new StringBuilder();

        while(s > 0){
            s--;
            int rem = s % 26;
            char letter = (char) ('A' + rem);
            res.append(letter);
            s /= 26;
        }
        return res.reverse().toString();
    }
}

