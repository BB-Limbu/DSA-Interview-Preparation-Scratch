package BitManipulation;
public class BinaryToDecimal {
    public static int binaryToDecimal(String nums){
        int res = 0;
        int power = 0;

        for(int i = nums.length()-1; i >= 0; i--){
            if(nums.charAt(i) == '1'){
                res += Math.pow(2, power);
            }
            power++;
        }
        return res;
    }
    public static void main(String[] args){
        String str  = " 111";
        System.out.println(binaryToDecimal(str));
    }
}
