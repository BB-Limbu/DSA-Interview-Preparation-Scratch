public class LetterCasePermutation {
        public List<String> letterCasePermutation(String s) {
            List<String> result = new ArrayList<>();

            backtrack(s.toCharArray(), 0, result);

            return result;
        }

        private void backtrack(char[] arr, int index, List<String> result) {

            // base case
            if (index == arr.length) {
                result.add(new String(arr));
                return;
            }

            // if digit, move ahead
            if (Character.isDigit(arr[index])) {
                backtrack(arr, index + 1, result);
            } else {

                // lowercase
                arr[index] = Character.toLowerCase(arr[index]);
                backtrack(arr, index + 1, result);

                // uppercase
                arr[index] = Character.toUpperCase(arr[index]);
                backtrack(arr, index + 1, result);
            }
        }
    }
