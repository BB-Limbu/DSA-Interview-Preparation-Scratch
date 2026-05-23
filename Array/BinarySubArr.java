public class BinarySubArr {

        public static boolean queryStr(String s, int n){
            for(int i = 1; i <= n; i++){
                String bin = Integer.toBinaryString(i); // convert number into binary

                if(!s.contains(bin)){
                    return false;
                }
            }
            return true;
        }


}
