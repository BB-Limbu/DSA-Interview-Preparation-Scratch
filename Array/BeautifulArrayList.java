
public class BeautifulArrayList {
    public  static ArrayList<Integer> beautifulArrList(int n){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        for(int i = 2; i <= n; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(Integer ele : ans){
                if(2*ele <= n){
                    temp.add(ele*2);
                }
            }
            for(Integer ele : ans){
                if(2*ele-1 <= n){
                    temp.add(ele*2-1);
                }
            }
            ans = temp;
        }
        return ans;
    }
    /*
    Approach 2
     */
    public static ArrayList<Integer> beautifulArray(int n){
        ArrayList<Integer> res = new ArrayList<>();
        divideConqure(1,1,res,n);
        return  res;
    }
    private static void divideConqure(int start, int increment, ArrayList<Integer> res, int n ){
        if(start + increment > n){
            res.add(start);
            return;
        }
        divideConqure(start, 2 * increment, res, n);
        divideConqure(start + increment, 2 * increment, res, n);
    }
    public static void main(String[] args){
        int n = 4;
        System.out.println(beautifulArrList(n));
    }
}

