public class FirstUniqueFreq {
    public static int firstUniqueFreq(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> mp = new HashMap<>();
        for(int val : map.values()){
            mp.put(val, mp.getOrDefault(val, 0) + 1);
        }

        for(int nm : nums){
            if(mp.get(map.get(nm)) == 1){
                return nm;
            }
        }
        return -1;
    }
}

