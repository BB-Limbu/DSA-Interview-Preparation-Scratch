

public class StringRev {
        public String reverseStr(String s, int k) {
            int n = s.length();
            int step = k * 2;
            char[] arr = s.toCharArray();
            for(int i = 0; i < s.length(); i += 2*k){
                if(i+k-1 < n){
                    reverse(i,i+k-1, arr);
                }else{
                    reverse(i, n-1, arr);
                }
            }
            String ans = new String(arr);
            return ans;

        }
        public void reverse(int i, int j, char[] str){
            while(i < j){
                char temp = str[i];
                str[i] = str[j];
                str[j] = temp;
                i++;
                j--;
            }
        }
    }
