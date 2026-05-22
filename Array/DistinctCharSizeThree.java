

public class DistinctCharSizeThree {
    public static int countGoodSubStr(String s){
        int left = 0;
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if(r - left + 1 == 3){
                if(map.size() == 3){
                    count++;
                }
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left) , 0 )-1);
                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
        }
        return count;

    }
    public static void main(String[] args){
        String s = "xyzzaz";
        System.out.println(countGoodSubStr(s));
    }
}

