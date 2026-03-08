

public class MonotonicArrList {
    public static boolean monotonicArrList(ArrayList<Integer> list){
        boolean increase = true;
        boolean decrease = true;
        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i) < list.get(i+1)){
                increase = false;
            }
            if(list.get(i) > list.get(i+1)){
                decrease = false;
            }
        }
        return increase || decrease;
    }
}

