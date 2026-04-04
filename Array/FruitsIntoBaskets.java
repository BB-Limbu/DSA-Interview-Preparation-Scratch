

public class FruitsIntoBaskets {

    public static int fruitsBaskets(int[] fruits){
        int n = fruits.length;
        int ans = 0;

        for(int i = 0;  i < fruits.length; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;

            for(int j = i; j < fruits.length; j++) {
                map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
                if(map.size() > 2){
                    break;
                }
                count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }


    public static int fruitBasket(int[] fruit){
        int ans = 0;
        int left = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int right = 0; right < fruit.length; right++){
            map.put(fruit[right], map.getOrDefault(fruit[right], 0) + 1);

            while(map.size() > 2){
                map.put(fruit[left], map.get(fruit[left]) -1);

                if(map.get(fruit[left]) == 0){
                    map.remove(fruit[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }a
}

