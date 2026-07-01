public class IsAdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        return backtrack(num, 0, new ArrayList<>());
    }

    private boolean backtrack(String s, int index, List<Long> list) {

        // Entire string is used
        if (index == s.length()) {
            return list.size() >= 3;
        }

        long curr = 0;

        for (int i = index; i < s.length(); i++) {

            // Leading zero
            if (i > index && s.charAt(index) == '0')
                break;

            curr = curr * 10 + (s.charAt(i) - '0');

            int size = list.size();

            if (size >= 2) {

                long sum = list.get(size - 1) + list.get(size - 2);

                if (curr < sum)
                    continue;

                if (curr > sum)
                    break;
            }

            list.add(curr);

            if (backtrack(s, i + 1, list))
                return true;

            list.remove(list.size() - 1);
        }

        return false;
    }
}