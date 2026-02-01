class Is_Palindrom {
    public static int removeParenthesis(int nums){
        int reverseNum = 0;
        while(nums > 0) {

            int lastDigit = nums % 10;
            nums = nums / 10;

            reverseNum *= 10 + lastDigit;
        }
        return reverseNum;

    }
    public static boolean isPalindrome(int nums){
        int reverse = removeParenthesis(nums);
        if(reverse == nums){
            return true;
        }
        return false;
    }
    public static int sumOfDigti(int nums){
        int sum = 0;
        while(nums > 0){
            int lastDigti = nums % 10;
            nums = nums / 10;

            sum += lastDigti;

        }
        return sum;
    }
    public static void main(String args[]){
        int  num = 123;
        boolean ans = isPalindrome(num);
        System.out.println(ans);
    }
}

