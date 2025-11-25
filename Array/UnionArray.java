

public class UnionArray {
    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int i = 0, j = 0;
        ArrayList<Integer> Union = new ArrayList<>();

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (Union.size() == 0 || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
            } else {
                if (Union.size() == 0 || Union.get(Union.size() - 1) != arr2[j])
                    Union.add(arr2[j]);
                j++;
            }
        }

        // Add remaining elements of arr1
        while (i < n) {
            if (Union.size() == 0 || Union.get(Union.size() - 1) != arr1[i])
                Union.add(arr1[i]);
            i++;
        }

        // Add remaining elements of arr2
        while (j < m) {
            if (Union.size() == 0 || Union.get(Union.size() - 1) != arr2[j])
                Union.add(arr2[j]);
            j++;
        }

        return Union;
    }
}
