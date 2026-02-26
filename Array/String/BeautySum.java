package String;


import java.util.*;

public class BeautySum {

    public static int beautySum(String str){
        int n = str.length();
        int sum = 0;

        for(int  i = 0; i < n; i++){
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j = i; j < n; j++) {

                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);

                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;

                for (int val : map.values()) {
                    max = Math.max(max, val);
                    min = Math.min(min, val);
                }
                sum += (max - min);
            }

        }
        return sum;
    }
}

