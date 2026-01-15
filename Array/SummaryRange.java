public class SummaryRange {
    public static List<String> SummaryRange(int[] nums){
        List<String> res = new ArrayList<>();
        if(nums.length == 0) return res;
        int start = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1] + 1){
                int end = nums[i -1];
                if(start == end){
                    res.add(String.valueOf(start));
                }else {
                    res.add(start + "->" + end);
                }
                start = nums[i];
            }

        }
        int end = nums[nums.length - 1];
        if(start == end){
            res.add(String.valueOf(start));
        }else{
            res.add(start +"->"+ end);

        }
        return res;
    }
    public static void main(String[] args0){
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(SummaryRange(nums));
    }
}
