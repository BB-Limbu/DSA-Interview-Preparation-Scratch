
public class ChainPairs {
    /*
    Time Complexity O(n log n)
    Space Complexity O(1)
     */
    public static int chainPairsLen(int[][] pairs){
        Arrays.sort(pairs, Comparator.comparingDouble(o->o[1]));

        int chainLen = 1;
        int endChain = pairs[0][1];

        for(int i = 1; i < pairs.length; i++){
            if(pairs[i][0] > endChain){
                chainLen++;
                endChain = pairs[i][1];
            }
        }
        return chainLen;
    }
    public static void main(String[] args){
        int[][] pairChain = {{5,24},{39,60},{5,28},{27, 40},{50,90}};
        System.out.println(chainPairsLen(pairChain));
    }
}
