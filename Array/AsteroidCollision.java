import java.util.*;

public class AsteroidCollision {
    /*
    Q. Asteroid Collision
    Time Complexity O(n) + O(n)
    Space Complexity O(n) + O(n)
     */
    public static int[] asteroidCollision(int[] astroides){
        int n = astroides.length;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if (astroides[i] > 0) {
                list.add(astroides[i]);
            }
            else{
                // Destroy all smaller right-moving asteroids
                while(!list.isEmpty() && list.get(list.size()-1)  > 0
                        && list.get(list.size()-1) < Math.abs(astroides[i])){
                    list.remove(list.size()-1);
                }
                // Destroy both if sizes are equal
                if(!list.isEmpty() && list.get(list.size()-1) == Math.abs(astroides[i])){
                    list.remove(list.size()-1);
                }
                // If top of stack is a left-moving or no asteroid, add this one
                else if(list.isEmpty() || list.get(list.size()-1) < 0){
                    list.add(astroides[i]);
                }

            }
        }
        // Convert the list to an array
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}

