

public  class MajorityElement {
    /*
    Q. Majority Element
    Time Complexity O(n)
    Space Complexity O(n)
     */
    public static int majorityElement(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
//           if(map.containsKey(arr[i])){
//               map.put(arr[i], map.get(arr[i]) + 1);
//           }else{
//               map.put(arr[i], 1);
//           }

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Set<Integer> keys = map.keySet();
        for(Integer key : map.keySet()){
            if(map.get(key) > arr.length/ 3){
                System.out.println(key);
                return map.get(key);
            }
        }
        return -1;
    }
    public static void main(String[] ars){
        int[] nums = { 1,3,5,1,1,8,1,9,1};
        System.out.println(majorityElement(nums));
    }
}

