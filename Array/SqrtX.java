


public class SqrtX {
    /*
    Q. Square(x)
    Better Approach(linear Search)
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public static int sqrtx(int x){
        if(x < 2){
            return x;
        }

        int i = 1;
        while(i <= x/2){
            long sqrt = (long) i * i;
            if(sqrt == x){
                return i;
            }
            else if(sqrt > x){
                return i -1;
            }
            i++;
        }
        return i-1;
    }
    /*
    Optimal Approach
    Time Complexity O(lon n)
    Space Complexity O(1)
     */
    public static int sqrtX(int x){
        if(x < 2){
            return x;
        }

        long left = 0, right = x/2;
        while(left <= right){
            long mid = left + (right - left) / 2;
            long sqrt = mid * mid;

            if(sqrt == x){
                return (int) mid;
            }
            else if(sqrt < x){
                left = mid + 1;
            }
            else{
                right = mid -1;
            }
        }
        return (int) right;
    }
}

