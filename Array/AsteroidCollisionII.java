

public class AsteroidCollisionII {
    public static int[] asteroidCollision(int[] asteroids){
        int n = asteroids.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int arr : asteroids){
            list.add(arr);
        }
        int  i = 0;
        while(i < list.size()-1){
            int firstEle = list.get(i);
            int secEle = list.get(i+1);

            if(firstEle > 0 && secEle < 0){
                if(Math.abs(firstEle) > Math.abs(secEle)){
                    list.remove(i+1);
                }
                else if(Math.abs(firstEle) < Math.abs(secEle)){
                    list.remove(i+1);
                }
                if(i > 0){
                    i--;
                }else{
                    list.remove(i);
                    list.remove(i+1);
                    if(i > 0) {
                        i--;
                    }
                }
            }else{
                i++;
            }
        }
        int[] ans = new int[list.size()];
        for(int j = 0; j < list.size(); j++){
            ans[j] = list.get(j);
        }
        return ans;
    }

}

