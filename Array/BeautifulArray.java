import java.util.ArrayList;

public class BeautifulArray {
    public static ArrayList<Integer> beautifulArray(int n){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        while(ans.size() < n){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < ans.size(); i++){  //odd element insert
                if((ans.get(i) *2-1) <= n){
                    temp.add(ans.get(i)*2-1);
                }
            }
            for(int i = 0; i < ans.size(); i++){ // even element insert
                if(ans.get(i)*2 <= n){
                    temp.add(ans.get(i)*2);
                }
            }
            ans = temp;
        }
        return ans;
    }
    public static void main(String[] args){

    }
}
