

public class BasketFruits {

    public static int fruitsBaskets(int[] fruits){
        int n = fruits.length;
        int maxLen = 0;
        for(int i = 0; i < n; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = i; j < n; j++){
                set.add(fruits[i]);
                if(set.size() <= 2){
                    maxLen = Math.max(maxLen, j-i+1);
                }
                else{
                    break;
                }
            }
        }
        return maxLen;
    }
    /*
    Optimal Approach
    Time Complexity O(n) + O(n) = O(2n)
    Space Complexity O(n)
     */

    public static int fruitsBasket(int[] fruits){
        int n = fruits.length;
        int maxLen = 0, left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int right = 0; right < n; right++){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while(map.size() > 2){
                map.put(fruits[left], map.get(fruits[left]) - 1); // reducing frequency of map
                if(map.get(fruits[left]) == 0){ // if frequency become zero remove key;
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}

